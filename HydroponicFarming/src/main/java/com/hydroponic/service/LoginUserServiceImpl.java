package com.hydroponic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hydroponic.exception.UserNotFindException;
import com.hydroponic.model.Credentials;
import com.hydroponic.model.CurrentSession;
import com.hydroponic.model.Customer;
import com.hydroponic.model.Login;
import com.hydroponic.model.PasswordGenerator;
import com.hydroponic.repository.CurrentSessionDAL;
import com.hydroponic.repository.SaveCustomerDAL;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginUserServiceImpl implements LoginUserServicIntr {

	@Autowired
	private SaveCustomerDAL customerDB;

	@Autowired
	private CurrentSessionDAL currentUserDB;

	@Autowired
	private PasswordGenerator passGenerater;

	@Override
	public String userLogin(Login logincred) {

		Optional<Customer> opt = customerDB.findById(logincred.getMobileNumber());

		if (opt.isEmpty()) {
			throw new UserNotFindException("Please signUp First..");
		}

		String p1 = passGenerater.getPass(new Credentials(logincred.getMobileNumber(), logincred.getPassword()));
		String p2 = opt.get().getPassword();

		if (!p1.equals(p2)) {
			throw new UserNotFindException("Password is incorrect");
		}

		CurrentSession currentSession = new CurrentSession();

		currentSession.setName(opt.get().getName());
		currentSession.setUserId(opt.get().getPhone());

		String uniqueID = RandomString.make(5);
		currentSession.setUniqueid(uniqueID);

		currentUserDB.save(currentSession);

		return uniqueID;

	}

	@Override
	public String logOutUser(String uniqueId) {

		String name = (currentUserDB.findById(uniqueId).get()).getName();

		currentUserDB.deleteById(uniqueId);

		return name + " has been loged out.";

	}

}
