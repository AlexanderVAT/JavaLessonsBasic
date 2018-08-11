package org.javalessons.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void shouldCompare2Numbers() {
        assertTrue("Fix the condition!", 1 < 100);
    }

    @Test
    public void shouldCheckConditionals() {
        int seed = 84;
        Integer multiplier = 3;

        if (seed < 20 || multiplier.toString() == null) {
            fail();
        } else if (seed * multiplier < 100) {
            fail();
        } else {
            assertEquals(252, multiplier * seed);
        }
    }

    @Test
    public void shouldIterateCollection() {
        List<String> list = new ArrayList<String>() {{
            add("one");
            add("two");
            add("three");
            add("four");
            add("five");
            add("six");
            add("seven");
            add("Foo");
        }};

        for (String s : list) {
            if (s.contains("foo")) {
                assertEquals("foo", s);
            }
            return;
        }

        fail();
    }

    @Test
    public void shouldLetToDepositMoneyToBankAccount() {
        BankAccount bank = new BankAccount(100);

        int deposit = 50;

        assertEquals(100 + deposit, bank.getCoins(deposit));
    }

    @Test
    public void shouldLetToWithdrawMoneyFromBankAccount() {
        BankAccount bank = new BankAccount(100);

        int moneyToWidthraw = 50;

        assertEquals(100 - moneyToWidthraw, bank.getCoins(moneyToWidthraw));
    }

    @Test
    public void hashmapPutTwoKey()

    {
        HashMap<String, String> map = new HashMap<>();
        map.put("Hello", "Hello");
        map.put("1", "1");
        assertEquals("Hello", map.get("Hello"));
        assertEquals("1", map.get("1"));
        assertFalse(!map.containsKey("1"));
    }


}
