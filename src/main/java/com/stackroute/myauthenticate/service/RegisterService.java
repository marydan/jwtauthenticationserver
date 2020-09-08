package com.stackroute.myauthenticate.service;

import java.util.List;

import com.stackroute.myauthenticate.model.Register;

public interface RegisterService {

	Register createUser(Register register);
	Register validateUser(String uname,String password);
	List<Register> showUsers();
	
}
