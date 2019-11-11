public class MoneyBefore {
    protected int amount;
    protected String currency;

    MoneyBefore(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }
    static MoneyBefore franc(int amount) {
        return new MoneyBefore(amount, "CHF");
    }
    static MoneyBefore dollar(int amount) {
        return new MoneyBefore(amount,"USD");
    }
    MoneyBefore times(int multiplier){
        return new MoneyBefore(amount*multiplier, currency);
    }
    public boolean equals(Object object){
        MoneyBefore money = (MoneyBefore) object;
        return amount == money.amount
                && currency().equals(money.currency());
    }
    public String currency() {
        return currency;
    }
    public String toString(){
        return amount + "  " + currency;
    }
    MoneyBefore plus(MoneyBefore addend){
        return new MoneyBefore(amount + addend.amount, currency);
    }

}
