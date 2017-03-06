package lycamPlusSdk.lycam.internal;

/**
 * @ClassName: HttpOperationException
 * @Describe: http连接过程中出现的异常
 * @Version: V0.1.0
 */
public class HttpOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HttpOperationException(){
		super();
	}

	public HttpOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	public HttpOperationException(String message) {
		super(message);
		
	}

	public HttpOperationException(Throwable cause) {
		super(cause);
	}
	
}
