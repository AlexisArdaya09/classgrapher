package core.exception;

/**
 * Connector Exception.
 *
 * @author David
 * @since 01/04/2018
 */
public class ConnectorException extends Exception {
  public ConnectorException() {
    super("Imposible create a connector incomplete");
  }
}
