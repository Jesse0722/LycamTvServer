package tv.lycam.services;

import org.springframework.web.multipart.MultipartFile;
import tv.lycam.domain.FileUploadedResponse;


/**
 * Created by lycam on 16/4/28.
 */
public interface FileUploadService {
	/***
	 * 上传头像文件
	 * @param userName
	 * @param file
	 * @return
	 */
	FileUploadedResponse fileAvatarUpload(String userName, MultipartFile file);
	
	FileUploadedResponse fileThumbnailsUpload(String userName, MultipartFile file);
	
	FileUploadedResponse fileUpload(String userName, MultipartFile file);

}
