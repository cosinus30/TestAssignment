import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import junit.framework.Assert;

public class TestCompute {
  Compute compute;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    compute = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void testMqSizeIsZero(){
    MessageQueue messageQueue = mock(MessageQueue.class);
    Mockito.when(messageQueue.size()).thenReturn(0);
    compute = new Compute(messageQueue);
    Assert.assertTrue(-1 == compute.countNumberOfOccurrences(""));
  }

  @Test
  public void testMqSizeIsNotZero(){
    MessageQueue messageQueue = mock(MessageQueue.class);
    Mockito.when(messageQueue.size()).thenReturn(4);
    compute = new Compute(messageQueue);
    Assert.assertTrue(-1 != compute.countNumberOfOccurrences("sdaa"));
  }

  @Test
  public void testMqContains(){
  /*  Mockito.when(messageQueue.contains(anyString())).thenReturn(false);
    Mockito.when(messageQueue.size()).thenReturn(4);
    Assert.assertEquals(compute.countNumberOfOccurrences("qqqq"), 0);*/
    MessageQueue messageQueue = mock(MessageQueue.class);
    Mockito.when(messageQueue.size()).thenReturn(4);
    Mockito.when(messageQueue.contains(anyString())).thenReturn(false);
    compute = new Compute(messageQueue);
    assertEquals(0, compute.countNumberOfOccurrences("qqqq"));
  }

  @Test
  public void returnValue(){
    MessageQueue messageQueue = mock(MessageQueue.class);
    Mockito.when(messageQueue.size()).thenReturn(4);
    Mockito.when(messageQueue.contains(anyString())).thenReturn(true);
    Mockito.when(messageQueue.getAt(0)).thenReturn("qqqq");
    Mockito.when(messageQueue.getAt(1)).thenReturn("qqqq");
    Mockito.when(messageQueue.getAt(2)).thenReturn("tttt");
    Mockito.when(messageQueue.getAt(3)).thenReturn("qqqq");
    compute = new Compute(messageQueue);
    assertTrue(3 == compute.countNumberOfOccurrences("qqqq"));

    
  }
}
