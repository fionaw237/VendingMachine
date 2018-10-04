import java.util.ArrayList;

public class CoinReturn {

    private ArrayList<Coin> coins;

    public CoinReturn(){
        coins = new ArrayList<>();
    }

    public int numberOfCoins(){
        return coins.size();
    }

    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    public double getTotal() {
        double total = 0;
        for (Coin coin : coins){
            total += coin.getValue();
        }
        return total;
    }

    public void empty() {
        coins.clear();
    }
}
