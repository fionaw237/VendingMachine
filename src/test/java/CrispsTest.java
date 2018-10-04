import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrispsTest {

    Crisps crisps;

    @Before
    public void setUp(){
        crisps = new Crisps("Salt and Vinegar");
    }

    @Test
    public void hasName() {
        assertEquals("Salt and Vinegar", crisps.getName());
    }

}
