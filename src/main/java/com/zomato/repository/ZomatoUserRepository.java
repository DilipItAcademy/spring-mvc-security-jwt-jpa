package com.zomato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zomato.entity.UserEntity;

@Repository
public interface ZomatoUserRepository extends JpaRepository<UserEntity, String>{

	UserEntity findByEmailIdAndPassword(String emailId, String password);


}
