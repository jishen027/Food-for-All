package com.team12.foodforall;

import com.team12.foodforall.domain.Project;
import com.team12.foodforall.domain.User;
import com.team12.foodforall.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author: Heng Gao
 * @date: 19/03/2022 22:48
 **/
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE )
@Rollback(false)

public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setId(123L);
        user.setEmail("ridsfassssf@gmail.com");
        user.setPassword("ravi2020");
        user.setFirstName("Ravi");
        user.setLastName("Kumar");
        user.setCharityName("Test Project Name");

        final Project project = new Project();
        Set<Project> projects = Set.of(project);
        user.setProjects(projects);


        User savedUser = entityManager.persist(user);
        User queryResult = repo.findByEmail(user.getEmail());

        assertThat(savedUser.getEmail()).isEqualTo(queryResult.getEmail());
        }


}

