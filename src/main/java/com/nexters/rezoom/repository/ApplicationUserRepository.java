package com.nexters.rezoom.repository;

import com.nexters.rezoom.domain.ApplicationUser;
import com.nexters.rezoom.dto.UserUpdateDTO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by JaeeonJin on 2018-08-02.
 */
public interface ApplicationUserRepository {
    ApplicationUser selectOneByUsernameOnSecurity(String username);
    void insertOne(ApplicationUser user);
    String getPassword(String username);
    String selectEmail(String username); // TODO : username -> email 수정
    void updateOne(@Param("updateDTO") UserUpdateDTO userUpdateDTO, @Param("username") String username);
}
