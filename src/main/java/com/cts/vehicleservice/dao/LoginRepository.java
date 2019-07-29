package com.cts.vehicleservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.vehicleservice.model.Login;

public interface LoginRepository  extends JpaRepository<Login, String> {

	@Query("SELECT userId FROM Login a WHERE userName = ?1 AND password = ?2")
    List<Login> findByUserNameAndPassword(@Param("userName") String userName, @Param("password")String password);
 

}
