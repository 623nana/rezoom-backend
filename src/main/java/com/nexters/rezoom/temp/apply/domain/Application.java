package com.nexters.rezoom.temp.apply.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

// aggregate root
@Getter @Setter
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

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "coverletter_id")
    private Coverletter coverletter;

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

}
