package core.exception;

public class CanNotBeCreatedException extends Exception{
  public CanNotBeCreatedException() {
    super("This object can't be created.");
  }
}
