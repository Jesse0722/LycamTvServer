package lycamPlusSdk.lycam.auth;

/**
 * @ClassName: InvalidCredentialsException
 * @Describe: 无效认证异常
 * @Version: V0.1.0
 */
public class InvalidCredentialsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException() {
        super();
    }

    public InvalidCredentialsException(String message) {
        super(message);
    }

    public InvalidCredentialsException(Throwable cause) {
        super(cause);
    }

    public InvalidCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
}
