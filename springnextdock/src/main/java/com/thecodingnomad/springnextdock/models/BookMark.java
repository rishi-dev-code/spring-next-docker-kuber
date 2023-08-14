package com.thecodingnomad.springnextdock.models;


import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="bookmarks")
public class BookMark {
    //https://stackoverflow.com/questions/74712236/im-creating-project-using-spring-boot-but-i-got-error-and-not-resolved-yet

    @Id
    //https://stackoverflow.com/questions/34705238/why-do-i-get-org-hibernate-mappingexception-could-not-instantiate-id-generator
    @SequenceGenerator(name="bm_id_seq_gen",sequenceName = "bm_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="bm_id_seq_gen" )
    @Column(name="book_id")
    private long id;

    @Column(name="book_title")
    private String title;

    @Column(name="book_url")
    private String url;

    @Column(name="created_at")
    private Instant createdAt;
}
