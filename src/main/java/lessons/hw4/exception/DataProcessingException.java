package lessons.hw4.exception;

/**
 * Custom exception class.
 */
public class DataProcessingException extends RuntimeException {

  /**
   * Constructor.
   *
   * @param message Error message.
   * @param cause Cause of exception.
   */
  public DataProcessingException(String message, Throwable cause) {
    super(message, cause);

  }

  /**
   * Constructor.
   *
   * @param message Error message.
   */
  public DataProcessingException(String message) {
    super(message);
  }
}
