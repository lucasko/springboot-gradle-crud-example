package org.example.repository;

import java.util.List;
import java.util.Optional;

import org.example.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User save(User user);

	List<User> findAll();

	void deleteById(Long id);

	Optional<User> findById(Long id);

	Optional<User> findByFirstname(String firstname);
	Optional<User> findByLastname(String lastname);
}