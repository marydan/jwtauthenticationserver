package com.stackroute.myauthenticate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.myauthenticate.model.Register;
import com.stackroute.myauthenticate.repo.RegisterRepo;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	RegisterRepo registerrepo;
	
	@Override
	public Register createUser(Register register) {

Register resultobj=registerrepo.save(register);
		return resultobj;
	}

	@Override
	public Register validateUser(String uname, String password) {
		
	Register registerout=registerrepo.findByUsernameAndPassword(uname, password);
		
		return registerout;
	}

	@Override
	public List<Register> showUsers() {

return registerrepo.findAll();
	}

}
