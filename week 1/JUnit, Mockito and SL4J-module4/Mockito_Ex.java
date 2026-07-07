package week1.tdd_logging;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

interface ExternalApi {
    String getData();
    void doVoidAction(String arg);
}

public class MockitoExercisesTest {

    // Exercise 1, 2 & 5: Mocking, Stubbing, and Multiple Returns
    @Test
    public void testMockingAndStubbing() {
        ExternalApi mockApi = mock(ExternalApi.class);
        
        // Multiple returns stubbing
        when(mockApi.getData()).thenReturn("First").thenReturn("Second");
        
        assertEquals("First", mockApi.getData());
        assertEquals("Second", mockApi.getData());
        
        // Exercise 2: Verify interaction
        verify(mockApi, times(2)).getData();
    }

    // Exercise 4 & 7: Void Methods and Exception Handling
    @Test
    public void testVoidMethods() {
        ExternalApi mockApi = mock(ExternalApi.class);
        
        // Stub void to throw exception
        doThrow(new RuntimeException("Void Error")).when(mockApi).doVoidAction("Bad");
        
        assertThrows(RuntimeException.class, () -> {
            mockApi.doVoidAction("Bad");
        });
    }

    // Exercise 6: Verifying interaction order
    @Test
    public void testOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        mockApi.getData();
        mockApi.doVoidAction("test");

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).doVoidAction("test");
    }
}
/*
OUTPUT:
Mockito tests completed.
BUILD SUCCESS
*/