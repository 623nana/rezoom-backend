package com.nexters.rezoom.temp.apply.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "coverletter")
public class Coverletter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coverletter_Id")
    private long Id;

    @Column(name = "pass_type")
    @Enumerated(EnumType.STRING)
    private PassType passType;

    @Column(name = "submit_type")
    @Enumerated(EnumType.STRING)
    private SubmitType submitType;

    @Column(name = "deadline")
    @JsonFormat(pattern = "yyyy-MM-dd HH")
    private Timestamp deadline;

    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   // @JoinColumn(name = "coverletter_Id")
   // private List<Question> questions;

    public Coverletter() {
        this.passType = PassType.WAIT;
        this.submitType = SubmitType.NON_SUBMIT;
    }

//    public Coverletter(List<Question> questions, PassType passType, SubmitType submitType) {
//        this();
//        this.questions = questions;
//        this.passType = passType;
//        this.submitType = submitType;
//    }

    protected void changeSubmit(SubmitType submitType) {
//        if (this.passType == PassType.PASS)
//             throw new Excetpion()
        this.submitType = submitType;
    }

    protected void changePass(PassType passType) {
//        if (this.submitType == SubmitType.NON_SUBMIT)
//            throw new exception() // 제출하지 않은 상태에서 합격으로 바꿀 수 없음.
        this.passType = passType;
    }

}
