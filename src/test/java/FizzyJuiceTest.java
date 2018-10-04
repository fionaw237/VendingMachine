import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzyJuiceTest {

    FizzyJuice fizzyJuice;

    @Before
    public void setUp(){
        fizzyJuice = new FizzyJuice("Irn Bru");
    }

    @Test
    public void hasName() {
        assertEquals("Irn Bru", fizzyJuice.getName());
    }

}
