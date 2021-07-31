/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PC
 */
public class UserDTO {
    private String userID;
    private String userName;
    private String password;
    private String address;
    private String phone;
    private String sex;
    private String roleID;

    public UserDTO() {
    }

    public UserDTO(String userID, String userName, String password, String address, String phone, String sex, String roleID) {
	this.userID = userID;
	this.userName = userName;
	this.password = password;
	this.address = address;
	this.phone = phone;
	this.sex = sex;
	this.roleID = roleID;
    }

    public String getUserID() {
	return userID;
    }

    public void setUserID(String userID) {
	this.userID = userID;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getSex() {
	return sex;
    }

    public void setSex(String sex) {
	this.sex = sex;
    }

    public String getRoleID() {
	return roleID;
    }

    public void setRoleID(String roleID) {
	this.roleID = roleID;
    }
    
    
}
