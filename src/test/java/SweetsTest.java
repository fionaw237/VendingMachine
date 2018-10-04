import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SweetsTest {

    Sweets sweets;

    @Before
    public void setUp(){
        sweets = new Sweets("Maltesers");
    }

    @Test
    public void hasName() {
        assertEquals("Maltesers", sweets.getName());
    }

}
