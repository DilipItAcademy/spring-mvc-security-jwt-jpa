package com.zomato.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zomato.dto.UserLogin;
import com.zomato.dto.UserRegister;
import com.zomato.entity.UserEntity;
import com.zomato.repository.ZomatoUserRepository;

@Service
public class ZomatoUserService implements UserDetailsService{

	@Autowired
	ZomatoUserRepository repository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public String registerUser(UserRegister request) {

		// Convert to Eneity Object
		UserEntity entity = new UserEntity();
		entity.setEmailId(request.getEmailId());
		entity.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
		entity.setFullName(request.getFullName());
		entity.setConatctNumber(request.getConatctNumber());

		repository.save(entity);

		return "User Created Successfully. Please Login Now.";
	}

	public String loginUser(UserLogin request) {

		UserEntity entity = repository.findByEmailIdAndPassword(request.getEmailId(), request.getPassword());

		System.out.println(entity);

		if (entity != null) {
			return "user Login Is Success. Welcome to home";
		} else {
			return "Invalid Credentials. Please Try Again";
		}

	}

	@Override
	public UserDetails loadUserByUsername(String emailID) throws UsernameNotFoundException {

		Optional<UserEntity> user =  repository.findById(emailID);
		
		UserEntity userDetails = user.orElseThrow(() -> new RuntimeException("EmailId Not Found."));
		
		return userDetails;
	}


}
