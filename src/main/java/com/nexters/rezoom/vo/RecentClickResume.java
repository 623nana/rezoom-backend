package com.nexters.rezoom.vo;

import java.sql.Timestamp;

/**
 * Created by JaeeonJin on 2018-08-18.
 */
public class RecentClickResume {
    private int resumeId;
    private String username;
    private Timestamp clickDate;

    public RecentClickResume() {
        this.clickDate = new Timestamp(System.currentTimeMillis());
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getClickDate() {
        return clickDate;
    }

    public void setClickDate(Timestamp clickDate) {
        this.clickDate = clickDate;
    }
}
