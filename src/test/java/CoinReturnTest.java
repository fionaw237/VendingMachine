import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinReturnTest {

    CoinReturn coinReturn;
    Coin coin;

    @Before
    public void setUp() throws Exception {
        coinReturn = new CoinReturn();
        coin = new Coin(CoinType.FIFTY);
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, coinReturn.numberOfCoins());
    }

    @Test
    public void canAddCoin() {
        coinReturn.addCoin(coin);
        assertEquals(1, coinReturn.numberOfCoins());
    }

    @Test
    public void canGetTotal() {
        coinReturn.addCoin(coin);
        coinReturn.addCoin(coin);
        assertEquals(1.0, coinReturn.getTotal(), 0.01);
    }

    @Test
    public void canEmptyCoinReturn() {
        coinReturn.addCoin(coin);
        coinReturn.addCoin(coin);
        coinReturn.empty();
        assertEquals(0, coinReturn.numberOfCoins());
    }
}
