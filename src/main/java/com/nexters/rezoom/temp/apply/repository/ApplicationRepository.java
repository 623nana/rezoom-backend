package com.nexters.rezoom.temp.apply.repository;

import com.nexters.rezoom.temp.apply.domain.Application;

public interface ApplicationRepository {
    void save(Application application);
    Application findById(long applicationId);
}
