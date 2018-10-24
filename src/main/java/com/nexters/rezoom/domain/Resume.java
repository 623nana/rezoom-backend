package com.nexters.rezoom.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.nexters.rezoom.domain.view.QuestionView;
import com.nexters.rezoom.domain.view.ResumeView;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Resume {
    private int resumeId;
    private String username;
    private int applicationYear;
    private String applicationType;

    @JsonView({ResumeView.Simple.class, QuestionView.Search.class})
    private String companyName;

    private String halfType;

    @JsonView({ResumeView.Simple.class, QuestionView.Search.class})
    private String jobType;

    private int finishFlag; // 지원 여부

    private int passFlag; // 합격 여부

    @JsonView(ResumeView.Deadline.class)
    @JsonFormat(pattern="yyyy-MM-dd HH")
    private Timestamp deadline; // 지원 마감일

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Timestamp createDate;

    @JsonIgnore
    @JsonView(ResumeView.ClickDate.class)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp clickDate;
}