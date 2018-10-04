import java.util.ArrayList;

public class Customer {

    private ArrayList<Coin> coins;

    public Customer(ArrayList<Coin> coins) {
        this.coins = coins;
    }

    public int numberOfCoins(){
        return this.coins.size();
    }

    public double getTotalMoney() {
        double total = 0;
        for (Coin coin : this.coins){
            total += coin.getValue();
        }
        return total;
    }

    public void pay(Coin coin) {
        this.coins.remove(coin);
    }
}
