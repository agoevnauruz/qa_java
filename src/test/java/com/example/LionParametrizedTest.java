package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    String sex;
    boolean hasMane;
    public  LionParametrizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Parameterized.Parameters(name = "sex: {0}, expectedResult: {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Самка", false},
                {"Самец", true},
        };
    }
    @Test
    public void doesHaveManeTests() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        assertEquals(hasMane, lion.doesHaveMane());
    }
}