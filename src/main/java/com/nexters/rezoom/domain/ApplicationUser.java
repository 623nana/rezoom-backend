package com.nexters.rezoom.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.nexters.rezoom.domain.view.UserView;
import lombok.Data;

/**
 * Created by JaeeonJin on 2018-07-17.
 */
@Data
public class ApplicationUser {
    @JsonView(UserView.SignUp.class)
    private String username; // id (email)

    @JsonView(UserView.SignUp.class)
    private String name; // nickname

    @JsonView(UserView.SignUp.class)
    private String password;

    @JsonView(UserView.UpdateInfo.class)
    private String newPassword;
}
