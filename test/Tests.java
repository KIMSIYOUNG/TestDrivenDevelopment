import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {


    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10),five.times(2));
        assertEquals(Money.dollar(15),five.times(3));
    }
    @Test
    public void testFrancMultiplication(){
        Money franc = Money.franc(5);
        assertEquals(Money.franc(10), franc.times(2));
        assertEquals(Money.franc(15), franc.times(3));
    }
    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.dollar(5).equals(Money.franc(5)));
    }

    @Test
    public void account(){

        myBank bank = new myBank("siyoung");
        bank.getDeposit();
        assertEquals(0, bank.getDeposit());
    }

}