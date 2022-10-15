package dz.bououza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService=new CalculatorService();

    @Test
    public void sumTest(){
        assertEquals(5,calculatorService.sum(3,2));
    }

    @Test
    public void minusTest(){
        assertEquals(1,calculatorService.minus(3,2));
    }
}
