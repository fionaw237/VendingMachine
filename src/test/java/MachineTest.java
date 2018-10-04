import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MachineTest {

    Machine machine;
    Slot slot;
    Slot slot1;
    CoinReturn coinReturn;
    Coin coin;
    Coin coin1;
    FizzyJuice fizzyjuice1;
    FizzyJuice fizzyjuice2;

    @Before
    public void setUp() {
        slot = new Slot(SlotCode.A1, 0.6);
        slot1 = new Slot(SlotCode.A2, 0.6);
        ArrayList<Slot> slots = new ArrayList<>();
        slots.add(slot);
        slots.add(slot1);
        coinReturn = new CoinReturn();

        fizzyjuice1 = new FizzyJuice("Irn Bru");
        fizzyjuice2 = new FizzyJuice("Irn Bru");

        slot.addProduct(fizzyjuice1);
        slot.addProduct(fizzyjuice2);

        machine = new Machine(slots, coinReturn);
        coin = new Coin(CoinType.FIFTY);
        coin1 = new Coin(CoinType.ONE);

    }

    @Test
    public void checkNumberOfSlots() {
        assertEquals(2, machine.getNumberOfSlots());
    }

    @Test
    public void checkHasCoinReturn() {
        assertEquals(coinReturn, machine.getCoinReturn());
    }

    @Test
    public void checkMoneyStartsEmpty() {
        assertEquals(0, machine.getNumberOfCoinsInCredit());
    }

    @Test
    public void canAddCoin() {
        machine.addCoin(coin);
        assertEquals(1, machine.getNumberOfCoinsInCredit());
    }

    @Test
    public void coinIsValid() {
        assertEquals(true, machine.checkValidity(coin));
    }

    @Test
    public void coinIsNotValid() {
        assertEquals(false, machine.checkValidity(coin1));
    }

    @Test
    public void coinCannotAddIfInvalid() {
        machine.addCoin(coin1);
        assertEquals(0, machine.getNumberOfCoinsInCredit());
    }

    @Test
    public void rejectedCoinGoesToCoinReturn() {
        machine.addCoin(coin1);
        assertEquals(1, coinReturn.numberOfCoins());
    }

    @Test
    public void canGetCredit() {
        machine.addCoin(coin);
        assertEquals(0.5, machine.getCredit(), 0.01);
    }

    @Test
    public void canFindSlotByCode() {
        Slot requestedSlot = machine.enterCode(SlotCode.A1);
        assertEquals(slot, requestedSlot);
    }

    @Test
    public void checkEnoughMoney() {
        machine.addCoin(coin);
        machine.addCoin(coin);
        Slot requestedSlot = machine.enterCode(SlotCode.A1);
        assertEquals(true, machine.canAfford(requestedSlot));
    }

    @Test
    public void checkNotEnoughMoney() {
        machine.addCoin(coin);
        Slot requestedSlot = machine.enterCode(SlotCode.A1);
        assertEquals(false, machine.canAfford(requestedSlot));
    }

    @Test
    public void canDispenseProduct() {
        machine.addCoin(coin);
        machine.addCoin(coin);
        Product requestedProduct = machine.dispense(SlotCode.A1);
        assertEquals(1, slot.getNumberOfProducts());
        assertEquals(fizzyjuice1,requestedProduct);
    }

    @Test
    public void canGetNumberOfCoinsInTill() {
        assertEquals(0, machine.getNumberOfCoinsInTill());
    }

    @Test
    public void canAddCreditToTill() {
        machine.addCoin(coin);
        Coin coin2 = new Coin(CoinType.TWENTY);
        machine.addCoin(coin2);
        machine.addCreditToTill();
        assertEquals(0, machine.getNumberOfCoinsInCredit());
        assertEquals(2, machine.getNumberOfCoinsInTill());
    }
}
