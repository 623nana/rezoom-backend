package com.nexters.rezoom.temp.apply.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_Id")
    private long Id;

    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "question_hashtag_mapping", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = {@JoinColumn(name = "hashtag_id"), @JoinColumn(name = "user_Id")})
    private Set<Hashtag> hashtags;

    public Question () {}

    public Question (String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
