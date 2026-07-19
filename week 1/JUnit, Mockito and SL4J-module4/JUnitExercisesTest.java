package week1.tdd_logging;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

// ==========================================================================
-- EXERCISE 2: WRITING BASIC CLASS TO TEST
// ==========================================================================
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

// ==========================================================================
// EXERCISE 1, 3 & 4: ALL JUNIT EXERCISES IN ONE FILE
// ==========================================================================
public class JUnitExercisesTest {

    private Calculator calc;

    // Exercise 4: Setup method runs BEFORE every single test case
    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Setup done: Calculator object created.");
    }

    // Exercise 2 & 4: Basic testing using the Arrange-Act-Assert (AAA) pattern
    @Test
    public void testCalculatorAddition() {
        // Arrange (Setup your variables)
        int num1 = 10;
        int num2 = 20;

        // Act (Run the code method)
        int result = calc.add(num1, num2);

        // Assert (Check if the answer matches)
        assertEquals(30, result);
    }

    // Exercise 3: Using different kinds of assertions
    @Test
    public void testVariousAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);
        
        // Assert true
        assertTrue(calc.isEven(4));
        
        // Assert false
        assertFalse(calc.isEven(7));
        
        // Assert null
        assertNull(null);
        
        // Assert not null
        assertNotNull(new Object());
    }

    // Exercise 4: Teardown method runs AFTER every single test case
    @After
    public void tearDown() {
        calc = null;
        System.out.println("Teardown done: Calculator cleared.");
    }
}

// --------------------------------------------------------------------------
// OUTPUTS LOGGED BELOW
// --------------------------------------------------------------------------
/*
Setup done: Calculator object created.
Teardown done: Calculator cleared.
Setup done: Calculator object created.
Teardown done: Calculator cleared.

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
*/