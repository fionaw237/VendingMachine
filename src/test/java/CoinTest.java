import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    Coin coin;

    @Before
    public void setUp() {
     coin = new Coin(CoinType.FIFTY);
    }

    @Test
    public void coinHasType () {
        assertEquals(CoinType.FIFTY, coin.getCoinType());
    }

    @Test
    public void coinHasValue() {
        assertEquals(0.5, coin.getValue(), 0.01);
    }
}
