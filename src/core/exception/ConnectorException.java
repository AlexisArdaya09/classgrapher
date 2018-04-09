package core.exception;

public class ConnectorException extends Exception {
  public ConnectorException() {
    super("Imposible create a connector incomplete");
  }
}
