package com.ust.bootsecurity.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.bootsecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository <User,Integer> {

	Optional<User> findByUserName(String username);

}
