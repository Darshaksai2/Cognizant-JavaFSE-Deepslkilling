package week1.tdd_logging;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

// ==========================================================================
// CLASSES TO TEST (EXERCISE 1, 4 & 5 CODE)
// ==========================================================================
class EvenChecker {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

class ExceptionThrower {
    public void throwException() {
        throw new IllegalArgumentException("Invalid input provided");
    }
}

class PerformanceTester {
    public void performTask() throws InterruptedException {
        // Mocking a quick operation
        Thread.sleep(50); 
    }
}

// ==========================================================================
// EXERCISE 1, 3, 4 & 5: ADVANCED TESTS IN ONE PAGE
// ==========================================================================
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Exercise 3: Setting up ordered tests
public class AdvancedJUnitTests {

    // Exercise 1: Parameterized Test using ValueSource
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 16, 32})
    @Order(1) // Exercise 3: This runs first
    public void testIsEvenWithDifferentInputs(int input) {
        EvenChecker checker = new EvenChecker();
        assertTrue(checker.isEven(input));
    }

    // Exercise 4: Exception Testing
    @Test
    @Order(2) // Exercise 3: This runs second
    public void testExpectedException() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException();
        });
    }

    // Exercise 5: Timeout and Performance Testing (Must finish in under 100ms)
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @Order(3) // Exercise 3: This runs third
    public void testPerformanceTimeout() throws InterruptedException {
        PerformanceTester tester = new PerformanceTester();
        tester.performTask();
    }
}

// ==========================================================================
// EXERCISE 2: TEST SUITES AND CATEGORIES
// ==========================================================================
// Note: In real work, you create a separate small file named AllTests.java like this:
/*
package week1.tdd_logging;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ JUnitExercisesTest.class, AdvancedJUnitTests.class })
public class AllTests {
    // This empty class links both files together into a single suite execution
}
*/

// --------------------------------------------------------------------------
// OUTPUTS LOGGED BELOW
// --------------------------------------------------------------------------
/*
✔ testIsEvenWithDifferentInputs(int) [1] 2 - Passed
✔ testIsEvenWithDifferentInputs(int) [2] 4 - Passed
✔ testIsEvenWithDifferentInputs(int) [3] 16 - Passed
✔ testIsEvenWithDifferentInputs(int) [4] 32 - Passed
✔ testExpectedException() - Passed
✔ testPerformanceTimeout() - Passed

All 6 tests completed successfully.
BUILD SUCCESS
*/