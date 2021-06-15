package com.codeup.spingblog.daos;

import com.codeup.spingblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepository extends JpaRepository <Ad, Long> {

    Ad findByTitle(String title); // select * from ads where title = ?
    Ad findFirstByTitle(String title); // select * from ads where title = ? limit 1
    Ad findByTitleLike(String searchPattern);  //find by title "%INPUT%"

    List<Ad> searchByTitle(String term);
}
