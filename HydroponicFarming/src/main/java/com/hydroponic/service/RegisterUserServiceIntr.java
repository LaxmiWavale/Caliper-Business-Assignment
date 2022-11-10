package com.hydroponic.service;

import com.hydroponic.model.UserAccountDetails;
import com.hydroponic.model.UserInput;

public interface RegisterUserServiceIntr {

	public UserAccountDetails registerUser(UserInput input);

}
