package lycamPlusSdk.lycam.internal;

import java.io.IOException;

import lycamPlusSdk.lycam.auth.CredentialsProvider;
import lycamPlusSdk.lycam.comm.HttpConnectManager;
import lycamPlusSdk.lycam.utils.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;



import com.fasterxml.jackson.core.type.TypeReference;
/**
 * @ClassName: LycamplusOperation
 * @Describe: 抽象类，所有操作都需要继承，提供操作的公共方法
 * 
 * @Version: V0.1.0
 */
public abstract class LycamplusOperation {
	/*
	 * httpRequest 传输格式
	 */
	private final static String JsonMime = "application/json";	
	private static Logger logger = Logger.getLogger(LycamplusOperation.class);
	private HttpClient httpClient;
	
	protected final static String RETURNFLAG = "success";
	protected CredentialsProvider credentialsProvider;
	protected JsonUtils jsonUtils;
	
	protected LycamplusOperation() {
		httpClient = HttpConnectManager.getHttpClient();
		jsonUtils = JsonUtils.getInstance();
	}

	public void setCredentialsProvider(CredentialsProvider credentialsProvider) {
		this.credentialsProvider = credentialsProvider;
	}

	/**
	 * @Name: doOepration
	 * @Description: 发送http请求，得到json字符串，解析为entity类型的实体类
	 * @Version: V0.1.0
	 * @param httpRequest 发送http的request
	 * @param entity 返回对象 解析的类型
	 * @return T 泛型
	 */
	protected <T> T doOperation(HttpRequestBase httpRequest,Class entity) {
		String json = sendRequest(httpRequest);
		if(logger.isDebugEnabled()) {
			logger.debug("response message is : \n" + json);
		}
		return (T) jsonUtils.json2obj(json, entity);	
	}
	/**
	 * @Name: doOepration
	 * @Description: 发送http请求，得到json字符串，解析为entity类型的实体类
	 * @Version: V0.1.0
	 * @param httpRequest 发送http的request
	 * @param entity 返回对象 解析的类型
	 * @return T 泛型
	 */
	protected Object doOperation(HttpRequestBase httpRequest) {
		String json = sendRequest(httpRequest);
		if(logger.isDebugEnabled()) {
			logger.debug("response message is : \n" + json);
		}
		return jsonUtils.json2obj(json,Object.class);
	}
	/**
	 * @Name: doOepration
	 * @Description: 发送http请求，得到json字符串，解析为entity类型的实体类
	 * @Version: V0.1.0
	 * @param httpRequest 发送http的request
	 * @param isPrivate 认证方式
	 * @param responseEntityType 返回对象 解析的类型
	 * @return T 泛型
	 */
	protected <T> T doOperation(HttpRequestBase httpRequest,boolean isPrivate,Class responseEntityType) {
		if(isPrivate) {
			httpRequest.addHeader(HttpHeaders.AUTHORIZATION, 
					"Bearer " + credentialsProvider.getCredentials().getPrivateAccessToken());
		} else {
			httpRequest.addHeader(HttpHeaders.AUTHORIZATION, 
					"Bearer " + credentialsProvider.getCredentials().getPublicAccessToken());
		}
		String json = sendRequest(httpRequest);
		if(logger.isDebugEnabled()) {
			logger.debug("response message is : \n" + json);
		}
		return (T) jsonUtils.json2obj(json, responseEntityType);	
	}
	/**
	 * @Name: doOepration
	 * @Description: 发送http请求，得到json字符串，解析为entity类型的实体类
	 * @Version: V0.1.0
	 * @param httpRequest 发送http的request
	 * @param isPrivate 认证方式
	 * @param typeReference 返回对象 解析的类型
	 * @return T 泛型
	 */
	protected <T> T doOperation(HttpRequestBase httpRequest,boolean isPrivate,TypeReference typeReference) {
		if(isPrivate) {
			httpRequest.addHeader(HttpHeaders.AUTHORIZATION,
					"Bearer " + credentialsProvider.getCredentials().getPrivateAccessToken());
		} else {
			httpRequest.addHeader(HttpHeaders.AUTHORIZATION,
					"Bearer " + credentialsProvider.getCredentials().getPublicAccessToken());
		}
		String json = sendRequest(httpRequest);

		return (T) jsonUtils.json2obj(json, typeReference);
	}
	
	/**
	 * @Name: sendRequest
	 * @Description: 发送http请求
	 * @Version: V0.1.0
	 * @param httpRequest 发送http的request
	 * @return String 返回的信息
	 */
	private String sendRequest(HttpRequestBase httpRequest) {
		httpRequest.addHeader(HttpHeaders.CONTENT_TYPE, JsonMime);
		String res = "";
		try {
			HttpResponse response = httpClient.execute(httpRequest);
			HttpEntity entity = response.getEntity();
			if(logger.isDebugEnabled()) {
				logger.debug("Http Response status : " + response.getStatusLine());
				logger.debug("Http Response entity : " + entity);
			}
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				res = entity!=null ? EntityUtils.toString(entity,"utf-8") : "";
			} else {
				throw new HttpOperationException(EntityUtils.toString(entity,"utf-8"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
}
