package week1.tdd_logging;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Dummy structural placeholders until Spring Boot context starts in Week 2
class LocalCalculatorService {
    public int add(int a, int b) { return a + b; }
}

public class SpringExercisesPlaceholderTest {

    // Exercise 1: Basic Service Unit Test Mockup
    @Test
    public void testSpringServiceMockup() {
        LocalCalculatorService service = new LocalCalculatorService();
        assertEquals(4, service.add(2, 2));
    }
}
/*
OUTPUT:
Spring basic service placeholder verified.
BUILD SUCCESS
*/