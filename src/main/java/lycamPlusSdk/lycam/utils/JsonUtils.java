package lycamPlusSdk.lycam.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
/**
 * @ClassName: JsonUtils 
 * @Describe: utils for json exchange for Object
 *         
 * @Version: V0.1.0
 */
public class JsonUtils {
	private volatile static JsonUtils ju;
	private volatile static JsonFactory jf;
	private volatile static ObjectMapper mapper;
	
	private JsonUtils(){
		
	}
	public static JsonUtils getInstance(){
		if(ju == null)
			synchronized (JsonUtils.class) {
				if(ju == null){
					ju = new JsonUtils();
				}
			}		
		return ju;
	}
	
	public static ObjectMapper getMapper(){
		if(mapper == null)
			synchronized (JsonUtils.class) {
				if(mapper == null){
					mapper = new ObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));	   
				}
			}
		return mapper;
	}
	
	public static JsonFactory getFactory(){
		if(jf == null)
			synchronized (JsonUtils.class) {
				jf = new JsonFactory();
			}
		return jf;
	}

	public String obj2json(Object obj){
		JsonGenerator jg = null;
		StringWriter out = new StringWriter();
		try {
			jf = getFactory();
			mapper = getMapper();
			jg = jf.createGenerator(out);
			mapper.writeValue(jg, obj);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return out.toString();
	}
	public String obj2jsondate(Object obj){
		JsonGenerator jg = null;
		StringWriter out = new StringWriter();
		try {
			jf = getFactory();
			mapper = new ObjectMapper().setDateFormat(new SimpleDateFormat("'{\"type\":\"Date\",'yyyy-MM-dd'T'HH:mm:ss.SSS'Z}'"));	   
			jg = jf.createGenerator(out);
			mapper.writeValue(jg, obj);
			ObjectNode root = (ObjectNode) mapper.readTree(out.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return out.toString();
	}
	public  Object json2obj(String json,Class<?> clz ){
		try {
			mapper = getMapper();
			return mapper.readValue(json, clz);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public  Object json2obj(String json,JavaType javaType){
		try {
			mapper = getMapper();
			return mapper.readValue(json, javaType);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public  Object json2obj(String json,TypeReference typeReference){
		try {
			mapper = getMapper();
			return mapper.readValue(json,typeReference);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public <T> List<T> json2list(String json,Class clz){
		try {
			mapper = getMapper();
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class,clz);
			return mapper.readValue(json, javaType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public <T> T[] json2Array(String json,Class<?> clz){
		try {
			mapper = getMapper();
			JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class,clz);
			return mapper.readValue(json, javaType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
}
