package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;
    @Test
    public void eatMeatReturnPredatorTest() throws Exception{
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }
    @Test
    public void getFamilyTypeTest(){
        Feline feline = new Feline();
        String expectedType = "Кошачьи";
        assertEquals(expectedType, feline.getFamily());
    }
    @Test
    public void getKittenCountTest(){
        Feline feline = new Feline();
        int expectedKittenCount = 1;
        assertEquals(expectedKittenCount, feline.getKittens());
    }
    @Test
    public void getKittensCount(){
        Feline feline = new Feline();
        int kittensCount = 5;
        int expectedKittensCount = 5;
        assertEquals(expectedKittensCount, feline.getKittens(kittensCount));
    }
}