package com.hcl.sandwich.controller;
/**
 * 
 * @author bojja.r
 * @version 1.0
 * @since 30-01-2020
 */

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.sandwich.dto.LoginDto;
import com.hcl.sandwich.dto.LoginResponseDto;
import com.hcl.sandwich.service.UserService;
import com.hcl.sandwich.util.SANDUTIL;

@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	
	 @Autowired 
	 UserService userService;
	 /**
		 * This method is used to validating the user by providing the input as LoginDto 
		 * @param loginDto
		 * @return responseDTO 
		 */
	 @PostMapping(value = "/login") 
	 public ResponseEntity<LoginResponseDto> usersLogin(@Valid @RequestBody LoginDto loginDto) { 
		 LOGGER.info(SANDUTIL.LOGIN_METHOD);
		 LoginResponseDto loginResponseDto = userService.usersLogin(loginDto);
		 return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
	 }
}