package org.olly.matillion.foodmart;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

public class TestFoodMartApplication {

    Logger log = mock(Logger.class);

    //@Test
    public void givenLessThanThreeParameters_whenProgramExecutes_executionAborts(){
        FoodmartApplication.log = log;
        FoodmartApplication.main(new String[]{"one", "two"});
        verify(log, times(1)).error("The correct number of parameters have not been provided. Please state department, pay type and education level in that order");
    }
}
