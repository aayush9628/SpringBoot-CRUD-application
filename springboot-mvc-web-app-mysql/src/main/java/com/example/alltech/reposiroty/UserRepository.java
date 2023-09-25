package com.example.alltech.reposiroty;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.alltech.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUseridAndPassword(String userid, String password);

}
