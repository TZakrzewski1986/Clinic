package clinic_app;

import static org.assertj.core.api.Assertions.assertThat;

import clinic_app.data.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("username");
        user.setPassword("Password01");
        user.setFirstName("Janusz");
        user.setLastName("Kowalski");

        User savedUser = userRepository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());
        assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
    }
}
