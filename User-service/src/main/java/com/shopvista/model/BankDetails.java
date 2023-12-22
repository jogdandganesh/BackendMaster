package com.shopvista.model;

import lombok.Data;

@Data
public class BankDetails {

	private int branchId;
	private String branchName;
	private int userId;
	private String ifscCode;
	private String userName;
	private long conatctNo;
	private String branchAddress;
	private String email;
	private long accountNo;

}
