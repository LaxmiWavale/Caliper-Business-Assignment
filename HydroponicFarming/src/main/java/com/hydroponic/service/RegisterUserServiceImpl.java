package com.hydroponic.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hydroponic.exception.UserAlreadyExistException;
import com.hydroponic.model.Credentials;
import com.hydroponic.model.Customer;
import com.hydroponic.model.PasswordGenerator;
import com.hydroponic.model.UserAccountDetails;
import com.hydroponic.model.UserInput;
import com.hydroponic.repository.RegisterUserDAL;

@Service
public class RegisterUserServiceImpl implements RegisterUserServiceIntr {

	@Autowired
	private RegisterUserDAL userDB;

	@Autowired
	private PasswordGenerator passGenerater;

	@Override
	public UserAccountDetails registerUser(UserInput input) {

		if ((userDB.findById(input.getPhone())).isPresent()) {
			throw new UserAlreadyExistException("You are already SignedUp please Login.");
		}

		Customer customer = new Customer();

		customer.setName(input.getName());
		customer.setPhone(input.getPhone());

		customer.setPassword(passGenerater.getPass(new Credentials(input.getPhone(), input.getPassword())));

		UserAccountDetails userAccountDetails = new UserAccountDetails();

		userAccountDetails.setMobileNumber(customer.getPhone());
		userAccountDetails.setCustomer(customer);
		userAccountDetails.setProductsList(new ArrayList<>());
		UserAccountDetails savedUser = userDB.save(userAccountDetails);

		userAccountDetails.getCustomer().setPassword(input.getPassword());
		savedUser.getCustomer().setPassword(input.getPassword());
		return savedUser;
	}
}
