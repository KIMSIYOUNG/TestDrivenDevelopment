
public class Franc extends Money{

    public Franc(int amount,String currency) {
        super(amount,currency);
    }

    public Money times(int times) {
        return Money.franc(amount*times);
    }

    @Override
    public String currency() {
        return "CHF";
    }


}

