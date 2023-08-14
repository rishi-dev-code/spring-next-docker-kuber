package com.thecodingnomad.springnextdock.repository;

import com.thecodingnomad.springnextdock.dto.BookmarkDTO;
import com.thecodingnomad.springnextdock.models.BookMark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface BookRepository extends JpaRepository<BookMark,Long> {
    List<BookMark> findAll();
    Page<BookmarkDTO> findBy(@PageableDefault(size=2) Pageable pageable);
    Page<BookmarkDTO> findByTitleContainsIgnoreCase(String query, Pageable pageable);
}
