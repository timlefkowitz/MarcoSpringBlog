package com.codeup.spingblog;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PostInsetRepository {

    @PersistenceContext
    private EntityManager entityManager;

}
