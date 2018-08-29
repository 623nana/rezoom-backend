package com.nexters.rezoom.domain;

import lombok.Data;

/**
 * Created by JaeeonJin on 2018-08-19.
 */
@Data
public class ResumeStatisticsSummary {
    private int resumeSize;
    private int pass;
    private int nonPass;
    private int submit;
    private int nonSubmit;
}
