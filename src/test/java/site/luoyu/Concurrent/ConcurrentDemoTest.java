package site.luoyu.Concurrent; 

import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static junit.framework.Assert.*;

/** 
* ConcurrentDemo Tester. 
* 
* @author <Authors name> 
* @since <pre>11/22/2016</pre> 
* @version 1.0 
*/ 
public class ConcurrentDemoTest {

    private static ConcurrentDemo demo = new ConcurrentDemo();

    @Before
    public void before() throws Exception {
        System.out.println("how many before");
    }

    @After
    public void after() throws Exception {
//        assertEquals(demo.getCount(),100);
        System.out.println(demo.getCount());
    }

    /**
    * Method: addCount()
    */
    @Test
    public void testAddCount() throws Exception {
        demo.addCount();
        System.out.println("how many threads");
    }
} 
