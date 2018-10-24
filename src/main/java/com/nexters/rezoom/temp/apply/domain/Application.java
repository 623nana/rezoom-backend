package com.nexters.rezoom.temp.apply.domain;

import javax.persistence.*;
import java.io.Serializable;

// aggregate root
@Entity
@Table(name = "application")
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_Id")
    private long id;

    // 지원 회사
    @Column(name = "company")
    private String company;

    // 직무
    @Column(name = "job_type")
    private String jobType;

    // 지원종류, value, 신입/인턴/경력/기타 등
    @Column(name = "apply_type")
    @Enumerated(EnumType.STRING)
    private ApplyType applyType;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "coverletter_id")
    private Coverletter coverletter;

    @Override
    public String toString() {
        return id+" "+company+" "+jobType+" "+applyType+" "+coverletter;
    }

    public Application () {}


    public Application (String company, String jobType) {
        this.company = company;
        this.jobType = jobType;
        this.applyType = ApplyType.JUNIOR;
    }

    public Application(String company, String jobType, ApplyType applyType) {
        this(company, jobType);
        this.applyType = applyType;
    }

    public Application(String company, String jobType, ApplyType applyType, Coverletter coverletter) {
        this.company = company;
        this.jobType = jobType;
        this.applyType = applyType;
        this.coverletter = coverletter;
    }

    // 자소서 문항 리스트, value
//    @OneToMany(cascade = {CascadeType.PERSIST}, orphanRemoval = true)
//    @JoinColumn(name = "coverletter_id")
//    @OrderColumn(name = "list_idx")

}
