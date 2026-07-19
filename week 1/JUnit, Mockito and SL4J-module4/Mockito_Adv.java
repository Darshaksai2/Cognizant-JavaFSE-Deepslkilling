package week1.tdd_logging;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

interface DatabaseRepo { String loadData(); }
interface RestClient { String fetchResponse(); }
interface MyFileReader { String readFile(); }

public class MockitoAdvancedExercisesTest {

    // Exercise 1: Mocking Repositories
    @Test
    public void testMockDatabase() {
        DatabaseRepo mockDb = mock(DatabaseRepo.class);
        when(mockDb.loadData()).thenReturn("DB Data");
        assertEquals("DB Data", mockDb.loadData());
    }

    // Exercise 2: Mocking External APIs
    @Test
    public void testMockApi() {
        RestClient mockClient = mock(RestClient.class);
        when(mockClient.fetchResponse()).thenReturn("API Response");
        assertEquals("API Response", mockClient.fetchResponse());
    }

    // Exercise 3: Mocking File IO
    @Test
    public void testMockFileIO() {
        MyFileReader mockReader = mock(MyFileReader.class);
        when(mockReader.readFile()).thenReturn("File Content");
        assertEquals("File Content", mockReader.readFile());
    }
}
/*
OUTPUT:
Advanced mock simulations passed.
BUILD SUCCESS
*/