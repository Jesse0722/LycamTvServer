package tv.lycam.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.ObjectMetadata;

import lycamPlusSdk.lycam.internal.HttpOperationException;
import lycamPlusSdk.lycam.utils.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tv.lycam.configs.AppConfig;
import tv.lycam.domain.FileUploadedResponse;
import tv.lycam.domain.User;


/**
 * Created by lycam on 16/4/28.
 */
@Service
public class FileUploadServiceImpl implements FileUploadService{

	private static Logger logger = Logger.getLogger(FileUploadServiceImpl.class);

	@Autowired
	private UserServiceImpl userService;
	
	@Override
	public FileUploadedResponse fileAvatarUpload(String userName, MultipartFile file) {
		// TODO Auto-generated method stub		
		
		FileUploadedResponse fileUploadedResponse=new FileUploadedResponse();
		
		User user=userService.getUserByName(userName);
		
		if(!file.isEmpty()&&user!=null){   
		 
			String fileName=file.getOriginalFilename();	
			String contentType=file.getContentType();

	            //上传到阿里云
			logger.debug("图片文件名:"+fileName+"   图片大小:"+  file.getSize()+"Content-tpye:"+contentType);
		    try {

				//转换成File文件格式
		    	File binFile=new File(file.getOriginalFilename());
				binFile.createNewFile();
				FileOutputStream fos=new FileOutputStream(binFile);
				fos.write(file.getBytes());
				fos.close();

				String key=userName+"_"+fileName;
				OSSClient client = new OSSClient(AppConfig.endpoint,AppConfig.accessKeyId,AppConfig.accessKeySecret);
				logger.debug("Uploading a new object to OSS from an input stream");
				ObjectMetadata meta = new ObjectMetadata();
				meta.setContentType(contentType);
				client.putObject(AppConfig.bucketName,key,binFile,meta);

				binFile.delete();//删除临时文件

				Date expires=new Date(new Date().getTime()+1000*60*3);
				GeneratePresignedUrlRequest generatePresignedUrlRequest=
						new GeneratePresignedUrlRequest(AppConfig.bucketName,key);
				generatePresignedUrlRequest.setExpiration(expires);
				URL url=client.generatePresignedUrl(generatePresignedUrlRequest);//获取图片urL

				//
				if(url!=null) {
					fileUploadedResponse.setBucket(AppConfig.bucketName);
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					fileUploadedResponse.setCreatedAt(df.format(new Date()));
					fileUploadedResponse.setName(userName);
					fileUploadedResponse.setUrl(url.toString());
					fileUploadedResponse.setObjectId(key);
					fileUploadedResponse.setSize((int)(file.getSize()));
					fileUploadedResponse.setSuccess(true);

					user.setAvatarUrl(fileUploadedResponse.getUrl());
					userService.updateUser(user);
				}
		    } 
		    catch (IOException e) {
		    	e.printStackTrace();
		    }
		}
		else{
			fileUploadedResponse.setSuccess(false);
		}
		return fileUploadedResponse;
	}
	
	@Override
	public FileUploadedResponse fileThumbnailsUpload(String userName, MultipartFile file) {
		FileUploadedResponse fileUploadedResponse=new FileUploadedResponse();
		
		User user=userService.getUserByName(userName);
		
		if(!file.isEmpty()&&user!=null){   
		 
			String fileName=file.getOriginalFilename();	
			String contentTpye=file.getContentType();

			//上传leancloud
		    try {
 
		    	HttpPost post=new HttpPost("https://api.leancloud.cn/1.1/files/"+fileName);
	             
		    	post.setHeader("X-LC-Id","axNEWvMUl47VnqDAnTeRqNyv-gzGzoHsz");
		    	post.setHeader("X-LC-Key","E2I7LAozwuoX97dfMC7VrRiQ");
		    	post.setHeader("Content-Type",contentTpye);
	                
	            File binFile=new File(file.getOriginalFilename());
	           // file.transferTo(binFile);
	            binFile.createNewFile();
		    	FileOutputStream fos=new FileOutputStream(binFile);
		    	fos.write(file.getBytes());
		    	fos.close();
	            
	            
	            HttpEntity entity=MultipartEntityBuilder.create().
	            				addPart("thumbnails", new FileBody(binFile)).build();
		    
		    	post.setEntity(entity);;
	            
				CloseableHttpClient client=HttpClients.createDefault();	          
				CloseableHttpResponse response=client.execute(post);
	             
				HttpEntity responseEntity=response.getEntity();           
				String res="";
				
				if(response.getStatusLine().getStatusCode()== 201){
					res=responseEntity!=null? EntityUtils.toString(responseEntity,"utf-8") : "";		
				}else{
					fileUploadedResponse.setSuccess(false);
					throw new HttpOperationException(EntityUtils.toString(responseEntity,"utf-8"));
				}
	                
				fileUploadedResponse=(FileUploadedResponse) JsonUtils.getInstance().
	            											   json2obj(res, FileUploadedResponse.class);
	            
				fileUploadedResponse.setSuccess(true);
	            	//将图片地址保存在本地
				user.setStreamImageUrl(fileUploadedResponse.getUrl());           
				userService.updateUser(user);
	       
		    } 
		    catch (IOException e) {
		    	e.printStackTrace();
		    }
		}
		else{
			fileUploadedResponse.setSuccess(false);
		}
		return fileUploadedResponse;
	}

	@Override
	public FileUploadedResponse fileUpload(String userName, MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}



}
