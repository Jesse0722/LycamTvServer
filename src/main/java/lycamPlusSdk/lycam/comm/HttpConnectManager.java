package lycamPlusSdk.lycam.comm;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;

/**
 * @ClassName: HttpConnectManager
 * @Describe: httpClient 缓存池，用来管理和建立httpClient
 * @Version: V0.1.0
 */
public class HttpConnectManager {
	private static PoolingHttpClientConnectionManager cm;
	/**
	 * 最大连接数
	 */
	public final static int MAX_TOTAL_CONNECTIONS = 200;
	/**
	 * 获取连接的最大等待时间
	 */
	public final static int WAIT_TIMEOUT = 60000;
	/**
	 * 每个路由最大连接数
	 */
	public final static int MAX_ROUTE_CONNECTIONS = 300;
	/**
	 * 连接超时时间
	 */
	public final static int CONNECT_TIMEOUT = 10000;
	/**
	 * 读取超时时间
	 */
	public final static int READ_TIMEOUT = 10000;
	
	static {
		SSLContext sslcontext = null;
		try {
			sslcontext = SSLContexts.custom().loadTrustMaterial(null,
			         new TrustSelfSignedStrategy())
			 .build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		 SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
		         sslcontext);
		 Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
		         .register("http", PlainConnectionSocketFactory.getSocketFactory())
		         .register("https", sslsf)
		         .build();
		
		cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		cm.setMaxTotal(MAX_TOTAL_CONNECTIONS);
		cm.setDefaultMaxPerRoute(80);
		
	}
	
	/**
	 * @Name: getHttpClient
	 * @Description: 生成一个httpClient
	 * @Version: V0.1.0
	 * @param CloseableHttpClient 新建立的httpclient
	 */
	public static CloseableHttpClient getHttpClient() {
		return  HttpClients.custom()
		        .setConnectionManager(cm)
		        .build();
	}
	
	/**
	 * @Name: release
	 * @Description: 释放连接池的所有链接
	 * @Version: V0.1.0
	 */
	public static void release(){
		if(cm != null){
			cm.shutdown();
		}
	}
}
