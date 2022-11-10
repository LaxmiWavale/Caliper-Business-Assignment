package com.hydroponic.service;

import com.hydroponic.model.Login;

public interface LoginUserServicIntr {

	public String userLogin(Login logincred);

	public String logOutUser(String uniqueId);

}
