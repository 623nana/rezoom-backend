package com.nexters.rezoom.temp.apply.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_Id")
    private long Id;

    @Column(name = "coverletter_id")
    private long coverletterId;

    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;

//    @ManyToMany
//    @Column(name = "hashtags")
//    private Set<String> hashtags;

    public Question (String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
