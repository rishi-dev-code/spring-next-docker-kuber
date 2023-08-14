package com.thecodingnomad.springnextdock.service;


import com.thecodingnomad.springnextdock.dto.BookmarkDTO;
import com.thecodingnomad.springnextdock.dto.BookmarksDTO;
import com.thecodingnomad.springnextdock.models.BookMark;
import com.thecodingnomad.springnextdock.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    final private BookRepository bookRepository;

    @Transactional(readOnly = true)
    public BookmarksDTO getAllBooks(Integer page){
        int pageNo = page < 1 ? 0 : page -1 ;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        Page<BookmarkDTO> bookmarkPage = this.bookRepository.findBy(pageable);
        return new BookmarksDTO(bookmarkPage);
    }
    @Transactional(readOnly = true)
    public BookmarksDTO searchBookmarks(String query, Integer page) {
        int pageNo = page < 1 ? 0 : page -1 ;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        //Page<BookmarkDTO> bookmarkPage = repository.searchBookmarks(query, pageable);
        Page<BookmarkDTO> bookmarkPage = this.bookRepository.findByTitleContainsIgnoreCase(query, pageable);
        return new BookmarksDTO(bookmarkPage);
    }
}
