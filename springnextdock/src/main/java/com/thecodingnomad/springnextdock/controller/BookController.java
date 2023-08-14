package com.thecodingnomad.springnextdock.controller;

import com.thecodingnomad.springnextdock.dto.BookmarksDTO;
import com.thecodingnomad.springnextdock.models.BookMark;
import com.thecodingnomad.springnextdock.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bookmarks")
public class BookController {
    final private BookService bookService;
    @GetMapping
    public ResponseEntity<BookmarksDTO> getBooks(
            @RequestParam(name = "page", defaultValue = "1",required = false) Integer page,
            @RequestParam(name = "query", defaultValue = "",required = false) String query

    )  {
        BookmarksDTO booksDTo = null;
        if(query == null || query.trim().length() == 0) {
            booksDTo = this.bookService.getAllBooks(page);
        }
        booksDTo = this.bookService.searchBookmarks(query,page);
        return new ResponseEntity<>(booksDTo, HttpStatus.OK);
    }

}
