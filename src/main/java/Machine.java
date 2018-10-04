import java.util.ArrayList;

public class Machine {

    private ArrayList<Slot> slots;
    private CoinReturn coinReturn;
    private ArrayList<Coin> coins;
    private ArrayList<Coin> till;

    public Machine(ArrayList<Slot> slots, CoinReturn coinReturn) {
        this.slots = slots;
        this.coinReturn = coinReturn;
        coins = new ArrayList<>();
        till = new ArrayList<>();
    }

    public int getNumberOfSlots() {
        return slots.size();
    }

    public CoinReturn getCoinReturn() {
        return coinReturn;
    }

    public int getNumberOfCoinsInCredit() {
        return coins.size();
    }

    public void addCoin(Coin coin) {
        if (checkValidity(coin)) {
            coins.add(coin);
        }
        else {
            coinReturn.addCoin(coin);
        }
    }

    public boolean checkValidity(Coin coin) {
        if (coin.getValue() > 0.02){
            return true;
        }
        return false;
    }

    public double getCredit() {
        double total = 0;
        for (Coin coin : coins){
            total += coin.getValue();
        }
        return total;
    }

    public Slot enterCode(SlotCode code) {
        for (Slot slot : slots) {
            if (slot.getCode() == code) {
                return slot;
            }
        }
        return null;
    }

    public boolean canAfford(Slot requestedSlot) {
        return getCredit() >= requestedSlot.getPrice();
    }

    public Product dispense(SlotCode code) {
        Slot slot = enterCode(code);
        if (canAfford(slot)){
            Product requestedProduct = slot.returnProduct();
//            addCreditToTill();
            return requestedProduct;
        }
        return null;
    }

    public void addCreditToTill(){
        for (Coin coin : coins){
            till.add(coin);
        }
        coins.clear();
    }

    public int getNumberOfCoinsInTill(){
        return till.size();
    }
}
