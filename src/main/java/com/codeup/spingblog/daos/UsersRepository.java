package com.codeup.spingblog.daos;

import com.codeup.spingblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {


}