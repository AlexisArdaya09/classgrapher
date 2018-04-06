package core.exception;

/**
 * ToolNotExistException.
 *
 * @author David
 * @since 05/04/2018
 */
public class CanNotBeCreatedException extends Exception{
  public CanNotBeCreatedException() {
    super("This object can't be created.");
  }
}
