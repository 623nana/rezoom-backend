package com.nexters.rezoom.controller;

import com.nexters.rezoom.dto.RecentClickResumeDTO;
import com.nexters.rezoom.dto.ResumeStatisticsDTO;
import com.nexters.rezoom.service.DashboardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * Created by JaeeonJin on 2018-08-19.
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @ApiOperation(value = "최근 조회한 이력서 리스트 중 상위 4개를 가져온다.")
    @GetMapping("/recent")
    @ResponseStatus(HttpStatus.OK)
    public List<RecentClickResumeDTO> getResumeDTOList(Principal principal) {
        return dashboardService.getRecentResumeClick(principal.getName());
    }

    @ApiOperation(value="합격, 불합격, 미제출 이력서의 통계 정보를 가져온다.")
    @GetMapping("/statistics/resume")
    public ResumeStatisticsDTO getDashboardInfo(Principal principal){
        return dashboardService.getResumeStatistics(principal.getName());
    }
}
