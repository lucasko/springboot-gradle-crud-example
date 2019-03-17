package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.example.config.Gender;
import org.example.domain.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;
 
	@Before
	public void initUserRepository() {
		when(this.userRepository.findAll()).thenReturn(
				Arrays.asList(	new User("Lucas", "Ko", Gender.M),
								new User("Mark", "Dai", Gender.M),
								new User("Dean", "Wei", Gender.M)
				));
	}
	
	@Test
    public void findAllTest(){
        List<User> users = userService.findAll();
      
        for(User user : users)
        	System.out.printf("Firstname=%s, Lastname=%s \n" 
        			, user.getFirstname() 
        			, user.getLastname() 
        			 );
        
        assertThat(users.get(1).getFirstname())
        .isEqualTo("Mark");
        
    }
}