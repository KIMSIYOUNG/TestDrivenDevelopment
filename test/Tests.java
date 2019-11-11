import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {


    @Test
    public void testMultiplication() {
        MoneyBefore five = MoneyBefore.dollar(5);
        assertEquals(MoneyBefore.dollar(10),five.times(2));
        assertEquals(MoneyBefore.dollar(15),five.times(3));
    }
    @Test
    public void testFrancMultiplication(){
        MoneyBefore franc = MoneyBefore.franc(5);
        assertEquals(MoneyBefore.franc(10), franc.times(2));
        assertEquals(MoneyBefore.franc(15), franc.times(3));
    }
    @Test
    public void testEquality(){
        assertTrue(MoneyBefore.dollar(5).equals(MoneyBefore.dollar(5)));
        assertFalse(MoneyBefore.dollar(5).equals(MoneyBefore.dollar(6)));
        assertFalse(MoneyBefore.dollar(5).equals(MoneyBefore.franc(5)));
    }
    @Test
    public void testSimpleAddition(){
        MoneyBefore sum = MoneyBefore.dollar(5).plus(MoneyBefore.dollar(5));
        assertEquals(MoneyBefore.dollar(10), sum);
    }
    @Test
    public void simplePlusAddition(){
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five,sum.augend);
        assertEquals(five,sum.addend);
    }
    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3),Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(7),result);
    }
    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1),"USD");
        assertEquals(Money.dollar(1),result);
    }
    @Test
    public void testIdentityRate(){
        assertEquals(1,new Bank().rate("USD","USD"));
    }
    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money result = bank.reduce(Money.franc(2),"USD");
        assertEquals(Money.dollar(1),result);
    }
    @Test
    public void testMixedAddition(){
        Expression fiveBucks = Money.dollar(5);
        Expression temFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money result = bank.reduce(
                fiveBucks.plus(temFrancs),"USD");
        assertEquals(Money.dollar(10),result);
    }
    @Test
    public void testSumPlusMoney(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Expression sum = new Sum(fiveBucks,tenFrancs).plus(fiveBucks);
        Money result = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(15),result);
    }
    @Test
    public void testSumTimes(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(20),result);
    }
}
