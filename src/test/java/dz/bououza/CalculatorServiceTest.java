package dz.bououza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    private CalculatorService calculatorService=new CalculatorService();

    @Test
    public void sumTest(){
        assertEquals(5,calculatorService.sum(3,2));
    }
}
