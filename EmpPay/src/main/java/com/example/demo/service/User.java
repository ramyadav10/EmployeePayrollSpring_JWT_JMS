package com.example.demo.service;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

	private String userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String phoneNo;
	private String dob;
	private LocalDateTime registerDate = LocalDateTime.now();
	private LocalDateTime updatedDate=LocalDateTime.now();
	private boolean verify;
	private String profilePic;
}
