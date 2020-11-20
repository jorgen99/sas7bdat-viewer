package se.jorgenlundberg.sasviewer;

public class NoSasFileException extends RuntimeException {

  public NoSasFileException(String message) {
    super(message);
  }

  public NoSasFileException(String message, Throwable cause) {
    super(message, cause);
  }
}
