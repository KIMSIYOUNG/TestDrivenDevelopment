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


}
