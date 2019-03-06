import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.beans.Transient;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void example() { assertTrue(true); }

  @Test
  public void oneLengthArg(){
    int [] arr = new int[1];
    assertFalse(c.compute(arr));
  }

  @Test
  public void evenLengthArg(){
    int [] arr = new int[2];
    assertFalse(c.compute(arr));
  }

  @Test(expected = RuntimeException.class)
  public void exception(){
    int [] arr = {0,1,2};
    boolean value = c.compute(arr);
  }

  @Test
  public void sumModiEqualsZero(){
    int [] arr = {1,2,3};
    assertTrue(c.compute(arr));
  }

  @Test
  public void sumModiIsNotEqualsZero(){
    int [] arr = {2,3,6};
    assertFalse(c.compute(arr));
  }
}