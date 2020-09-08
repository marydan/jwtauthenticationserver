package com.stackroute.myauthenticate.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.myauthenticate.model.Register;
import com.stackroute.myauthenticate.service.RegisterService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
	
	@Autowired
	RegisterService registerservice;
	
	@PostMapping("/addUser")
  public ResponseEntity<?> adduser(@RequestBody Register registernew)
  {
	Register registerresult=registerservice.createUser(registernew)	;
	return new ResponseEntity<Register>(registerresult,HttpStatus.OK);
  }
	
	@GetMapping("/showUser")
	public ResponseEntity<?> showUsers()
	{
		List<Register> registerusers=registerservice.showUsers();
		return new ResponseEntity<List>(registerusers,HttpStatus.OK);
	}
  
@GetMapping("/login")
public ResponseEntity<?> validateUser(@RequestBody Register register)
{
	Register registeroutput=registerservice.validateUser(register.getUsername(), register.getPassword());
	
	if(registeroutput!=null)
	{
	 String mytoken=generateToken(registeroutput)	;
	 
	 HashMap<String,String> mymap=new HashMap();
	 mymap.put("token",mytoken);
	 return new ResponseEntity<HashMap>(mymap,HttpStatus.ACCEPTED);
	 
	}
	
	else
		return new ResponseEntity<String>("Invalid User",HttpStatus.UNAUTHORIZED);
}
	

public String generateToken(Register obj)
{
	long expiry=10_00_0000;
	  
	return  Jwts.builder().setSubject(obj.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
	  .setExpiration(new Date(System.currentTimeMillis()+expiry)).signWith(SignatureAlgorithm.HS256, "jwtsecret").compact();
	
	
}

}
