package com.nexters.rezoom.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.nexters.rezoom.domain.HashTag;
import com.nexters.rezoom.domain.Resume;
import com.nexters.rezoom.domain.view.QuestionView;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Question {
    @JsonView(QuestionView.Simple.class)
    private int questionId;

    @JsonView(QuestionView.Simple.class)
    private String title;

    @JsonView(QuestionView.Simple.class)
    private String content;

    @JsonView(QuestionView.Simple.class)
    private List<HashTag> hashTags;

    @JsonView(QuestionView.Search.class)
    private Resume resume;

    public void setHashTags(String commaSeperatedHashtag) {
        String [] hashTags = commaSeperatedHashtag.split(",");
        this.hashTags = new ArrayList<>();
        for (String hashTagKeyword : hashTags) {
            this.hashTags.add(new HashTag(hashTagKeyword));
        }
    }
}
