package week1.tdd_logging;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

// ==========================================================================
// CLASSES FROM THE PDF (User, Repo, and Service Mockups)
// ==========================================================================
class UserProfile {
    private Long id;
    private String name;

    public UserProfile(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() { return name; }
}

interface LocalUserRepository {
    UserProfile findById(Long id);
}

class LocalUserService {
    private LocalUserRepository repository;
    
    public LocalUserService(LocalUserRepository repository) {
        this.repository = repository;
    }
    
    public UserProfile getUserById(Long id) {
        return repository.findById(id);
    }
}

// ==========================================================================
// MOCK DEPENDENCY EXERCISES IN ONE PAGE
// ==========================================================================
public class MockitoDependenciesTest {

    // Exercise 1 & 2: Mocking a Repository inside a Service Test
    @Test
    public void testUserServiceWithMockRepository() {
        // Step 1: Create the mock repository dependency
        LocalUserRepository mockRepo = mock(LocalUserRepository.class);
        
        // Step 2: Stub the method to return a dummy user profile object
        UserProfile dummyUser = new UserProfile(101L, "Darshak");
        when(mockRepo.findById(101L)).thenReturn(dummyUser);
        
        // Step 3: Inject the mock into the service layer
        LocalUserService service = new LocalUserService(mockRepo);
        UserProfile result = service.getUserById(101L);
        
        // Step 4: Verify the service logic works and values match up
        assertNotNull(result);
        assertEquals("Darshak", result.getName());
        verify(mockRepo).findById(101L);
    }
}
/*
OUTPUT:
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
Mock dependency validation cleared.
BUILD SUCCESS
*/