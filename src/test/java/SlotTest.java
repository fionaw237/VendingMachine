import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SlotTest {

    Slot slot;
    FizzyJuice fizzyJuice1;
    FizzyJuice fizzyJuice2;
    FizzyJuice fizzyJuice3;
    ArrayList<Product> fizzyJuices;

    @Before
    public void setUp() {
        fizzyJuice1 = new FizzyJuice("Irn Bru");
        fizzyJuice2 = new FizzyJuice("Irn Bru");
        fizzyJuice3 = new FizzyJuice("Irn Bru");

        fizzyJuices = new ArrayList<>();
        fizzyJuices.add(fizzyJuice1);
        fizzyJuices.add(fizzyJuice2);
        fizzyJuices.add(fizzyJuice3);

        slot = new Slot("C4", fizzyJuices, 0.6);
    }

    @Test
    public void hasCode() {
        assertEquals("C4", slot.getCode());
    }

    @Test
    public void hasProducts() {
        assertEquals(3, slot.stock());
    }

//    @Test
//    public void canGetPrice() {
//        assertEquals(0.6, slot.getProductPrice());
//    }
}
