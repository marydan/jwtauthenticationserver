package com.stackroute.myauthenticate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.myauthenticate.model.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register,String> {
	
Register findByUsernameAndPassword(String uname,String password);

}
