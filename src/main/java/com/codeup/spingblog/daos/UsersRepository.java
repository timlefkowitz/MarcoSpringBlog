package com.codeup.springlecture.daos;


import com.codeup.springlecture.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}