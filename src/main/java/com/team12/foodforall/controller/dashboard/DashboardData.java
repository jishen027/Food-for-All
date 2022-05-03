package com.team12.foodforall.controller.dashboard;

import lombok.Data;

import java.util.Map;

/**
 * @author: Heng Gao
 * @date: 03/05/2022 00:21
 **/
@Data
public class DashboardData {
    int totalRevenue;
    int numOfProjects;
    int numOfCompletedProjects;
    Map<Long,Float> revenueList;
    Map<Long,Float> averageRevueList;
}

