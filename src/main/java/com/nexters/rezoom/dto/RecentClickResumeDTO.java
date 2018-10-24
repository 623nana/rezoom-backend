package com.nexters.rezoom.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by JaeeonJin on 2018-08-18.
 */
@Data
public class RecentClickResumeDTO {
    private int resumeId;
    private String username;
    private Timestamp clickDate;

    public RecentClickResumeDTO() {
        this.clickDate = new Timestamp(System.currentTimeMillis());
    }
}
