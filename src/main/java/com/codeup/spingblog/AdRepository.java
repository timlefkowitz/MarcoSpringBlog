package com.codeup.spingblog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository <Ad, Long> {

    Ad findByTitle(String title); // select * from ads where title = ?
    Ad findFirstByTitle(String title); // select * from ads where title = ? limit 1
    Ad findByTitleLike(String searchPattern);  //find by title "%INPUT%"
}
