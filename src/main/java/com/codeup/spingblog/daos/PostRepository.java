package com.codeup.spingblog.daos;

import com.codeup.spingblog.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{

    Post findPostByID(long id);
    Post findPostByTitle(String title);


}
