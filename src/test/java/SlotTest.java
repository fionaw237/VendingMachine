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

        slot = new Slot(SlotCode.A1,0.6);
    }

    @Test
    public void hasCode() {
        assertEquals(SlotCode.A1, slot.getCode());
    }

    @Test
    public void canGetPrice() {
        assertEquals(0.6, slot.getPrice(), 0.01);
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, slot.getNumberOfProducts());
    }

    @Test
    public void canAddProduct() {
        slot.addProduct(fizzyJuice1);
        assertEquals(1, slot.getNumberOfProducts());
    }

    @Test
    public void canOnlyAddOneTypeOfProduct() {
        slot.addProduct(fizzyJuice1);
        Crisps crisps = new Crisps("Salt and Vinegar");
        slot.addProduct(crisps);
        assertEquals(1, slot.getNumberOfProducts());
    }

    @Test
    public void canAddTwoProductsOfSameType() {
        slot.addProduct(fizzyJuice1);
        slot.addProduct(fizzyJuice2);
        assertEquals(2, slot.getNumberOfProducts());
    }

    @Test
    public void canRemoveProduct() {
        slot.addProduct(fizzyJuice1);
        slot.addProduct(fizzyJuice2);
        assertEquals(fizzyJuice1, slot.returnProduct());
    }
}
