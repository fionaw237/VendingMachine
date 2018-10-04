import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;
    Coin coin1;
    Coin coin2;
    Coin coin3;
    ArrayList<Coin> coins;

    @Before
    public void setUp() {

        coin1 = new Coin(CoinType.FIFTY);
        coin2 = new Coin(CoinType.TEN);
        coin3 = new Coin(CoinType.FIVE);

        coins = new ArrayList<>();
        coins.add(coin1);
        coins.add(coin2);
        coins.add(coin3);

        customer = new Customer(coins);
    }

    @Test
    public void hasMoney() {
        assertEquals(3, customer.numberOfCoins());
    }

    @Test
    public void canGetTotalMoney() {
        assertEquals(0.65, customer.getTotalMoney(), 0.01);
    }

    @Test
    public void canUseCoinToPay() {
        customer.pay(coin1);
        assertEquals(0.15, customer.getTotalMoney(), 0.01);
    }
}
