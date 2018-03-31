import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by David on 31/03/2018.
 */
public class MainTest {
  @Test
  public void test() {
    Example example = new Example();
    Assertions.assertEquals(2, example.add(1,1));
  }
}
