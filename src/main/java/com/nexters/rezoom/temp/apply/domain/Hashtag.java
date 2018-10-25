package com.nexters.rezoom.temp.apply.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@Entity
@Table(name = "hashtag")
public class Hashtag {

    @EmbeddedId
    private HashtagId id;

    @Column(name = "value")
    private String value;

    @JsonIgnore
    @ManyToMany(mappedBy = "hashtags")
    private List<Question> questions;

    public Hashtag () {}

    public Hashtag (String userId, String value) {
        this.id = new HashtagId(userId);
        this.value = value;
    }

    public Hashtag(HashtagId id, String value, List<Question> questions) {
        this.id = id;
        this.value = value;
        this.questions = questions;
    }
}

@Embeddable
@Getter
@Setter
class HashtagId implements Serializable {
    @Column(name = "hashtag_id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    public HashtagId () {
        this.id = UUID.randomUUID().toString();
    }

    public HashtagId(String userId) {
        this();
        this.userId = userId;
    }
}