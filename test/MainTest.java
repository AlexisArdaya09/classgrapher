import org.junit.Assert;
import org.junit.Test;

/**
 * Created by David on 31/03/2018.
 */

public class MainTest {
  @Test
  public void test() {
    Example example = new Example();
    Assert.assertEquals(2, example.add(1,1));
  }
}
