package com.qurban.javabean;

public abstract class Committee {
	String committeeID;
	String committeeName;
	String committeePhoneNum;
	String committeeBirthDate;
	String committeeAddress;
	String managerID;
	
	// Constructor ------------------
	public Committee() {
		
		committeeID = "Unknown";
		committeeName = "Unknown";
		committeePhoneNum = "Unknown";
		committeeBirthDate = "Unknown";
		committeeAddress = "Unknown";
		managerID = "Unknown";
		
	}
	public Committee(String ID, String name, String phoneNum, String date, String address, String manID) {
		
		committeeID = ID;
		committeeName = name;
		committeePhoneNum = phoneNum;
		committeeBirthDate = date;
		committeeAddress = address;
		managerID = manID;
		
	}
	
	public Committee(String name, String phoneNum, String date, String address, String manID) {
		// without ID
		committeeName = name;
		committeePhoneNum = phoneNum;
		committeeBirthDate = date;
		committeeAddress = address;
		managerID = manID;
		
	}
	
	
	// Setter -------------------------------
	public void setCommitteeID(String ID) {
		committeeID = ID;
	}
	public void setCommitteeName(String name) {
		committeeName = name;
	}
	public void setCommitteePhoneNum(String phoneNum) {
		committeePhoneNum = phoneNum;
	}
	public void setCommitteeBirthDate(String date) {
		committeeBirthDate = date;
	}
	public void setCommitteeAddress(String address) {
		committeeAddress = address;
	}
	public void setManagerID(String manID) {
		managerID = manID;
	}
	
	// Getter ------------------------------
	public String getCommitteeID() {
		return committeeID;
	}
	public String getCommitteeName() {
		return committeeName;
	}
	public String getCommitteePhoneNum() {
		return committeePhoneNum;
	}
	public String getCommitteeBirthDate() {
		return committeeBirthDate;
	}
	public String getCommitteeAddress() {
		return committeeAddress;
	}
	public String getManagerID() {
		return managerID;
	}
	
	// Methods ---------------------------
	
	
	
	
	
	
}
