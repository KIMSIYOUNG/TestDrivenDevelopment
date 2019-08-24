import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Tests {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
        System.out.println(five);
    }
    @Test
    public void account(){

        myBank bank = new myBank("siyoung");
        bank.getDeposit();
        assertEquals(0, bank.getDeposit());
    }

}
