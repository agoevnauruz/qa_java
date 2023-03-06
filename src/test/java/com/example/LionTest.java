package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getFoodReturnValue() throws Exception{
        Lion lion = new Lion("Самец", feline);
        lenient().when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, actual);
    }
    @Test
    public void getKittenCountTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int actualResult = lion.getKittens();
        int expectedKittenCount = 1;
        assertEquals(expectedKittenCount, actualResult);
    }
    @Test
    public void lionExceptionTest() {
        String expectedException = "Используйте допустимые значения пола животного - самец или самка";
        Exception actualException = assertThrows("Текст исключения", Exception.class, () -> new Lion("", new Feline()));
        assertEquals("Текст исключения отличается от ожидаемого: ", expectedException, actualException.getMessage());
    }
}