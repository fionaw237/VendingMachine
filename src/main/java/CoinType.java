public enum CoinType {

    ONE(0.01),
    TWO(0.02),
    FIVE(0.05),
    TEN(0.10),
    TWENTY(0.20),
    FIFTY(0.50),
    POUND(1.00);

    private final double value;

    CoinType(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }
}
