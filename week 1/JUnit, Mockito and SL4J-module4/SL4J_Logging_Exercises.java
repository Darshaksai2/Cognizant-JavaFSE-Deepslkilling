package week1.tdd_logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLoggingExercisesTest {
    private static final Logger logger = LoggerFactory.getLogger(Slf4jLoggingExercisesTest.class);

    @Test
    public void testLoggingLevelsAndParameters() {
        // Exercise 1: Error and Warning logs
        logger.error("This is an error message");
        logger.warn("This is a warning message");

        // Exercise 2: Parameterized logging using {}
        String task = "Weekly Upload";
        int statusId = 200;
        logger.info("Task '{}' completed with status code: {}", task, statusId);
    }
}
/*
OUTPUT:
14:15:22.102 [main] ERROR week1.tdd_logging.Slf4jLoggingExercisesTest - This is an error message
14:15:22.105 [main] WARN  week1.tdd_logging.Slf4jLoggingExercisesTest - This is a warning message
14:15:22.106 [main] INFO  week1.tdd_logging.Slf4jLoggingExercisesTest - Task 'Weekly Upload' completed with status code: 200
*/