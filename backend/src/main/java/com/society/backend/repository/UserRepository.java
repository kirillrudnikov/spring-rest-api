package com.society.backend.repository;

import com.society.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    User getById(Long id);

    @Override
    Optional<User> findById(Long id);

}