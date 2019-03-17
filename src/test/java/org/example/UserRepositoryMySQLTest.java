package org.example;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

import org.example.config.Gender;
import org.example.domain.User;
import org.example.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryMySQLTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private UserRepository USER_REPOSITORY;
 
    // write test cases here
 


    @Test
    //@Rollback(false)  // default is true
    public void whenFindByFirstname_thenReturnUser() {
        // given
        User user = new User();
        user.setBirthdate(new Date());
        user.setFirstname("Lucas");
        user.setGnder(Gender.M);
        user.setLastname("Ko");
        user.setHiredate(new Date());
        
        // save 
        entityManager.persist(user);        
        entityManager.flush();

        // find
        Optional<User> found = USER_REPOSITORY.findByFirstname(user.getFirstname());
     
        System.out.println("user id="+found.get().getId());
     
        // then
        assertThat(found.get().getFirstname())
          .isEqualTo(user.getFirstname());
    }
    
    
}