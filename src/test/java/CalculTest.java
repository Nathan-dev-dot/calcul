import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CalculTest {
    @Test
    public void CalculAdd() {
        Calcul calcul = new Calcul();
        List<Integer> numbers = List.of(1, 2, 3);
        assertEquals(6, calcul.add(numbers));
    }

    @Test
    public void CalulTime() {
        Calcul calcul = new Calcul();
        List<Integer> numbers = List.of(1, 2, 3);
        assertEquals(6, calcul.time(numbers));
    }

    @Test
    public void ShouldThrowAnErrorBecauseCalculNotPermited() {
        Calcul calcul = new Calcul();
        List<Integer> numbers = List.of(1, 2, 3);

        ArithmeticException thrown = assertThrows(
                ArithmeticException.class,
                () ->calcul.process(numbers, "/"),
                "Expected calcul() to throw, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("Not permitted"));
    }
}