package core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 31/03/2018.
 */
public class LogicBoard {
  private List<Connector> connectors = new ArrayList<>(0);

  public void addConnector(Connector connector) {
    connectors.add(connector);
  }
}
