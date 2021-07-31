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
public class UserError {
    private String userIDError;
    private String userNameError;
    private String passwordError;
    private String addressError;
    private String phoneError;
    private String sexError;

    public UserError() {
    }

    public UserError(String userIDError, String userNameError, String passwordError, String addressError, String phoneError, String sexError) {
	this.userIDError = userIDError;
	this.userNameError = userNameError;
	this.passwordError = passwordError;
	this.addressError = addressError;
	this.phoneError = phoneError;
	this.sexError = sexError;
    }

    public String getUserIDError() {
	return userIDError;
    }

    public void setUserIDError(String userIDError) {
	this.userIDError = userIDError;
    }

    public String getUserNameError() {
	return userNameError;
    }

    public void setUserNameError(String userNameError) {
	this.userNameError = userNameError;
    }

    public String getPasswordError() {
	return passwordError;
    }

    public void setPasswordError(String passwordError) {
	this.passwordError = passwordError;
    }

    public String getAddressError() {
	return addressError;
    }

    public void setAddressError(String addressError) {
	this.addressError = addressError;
    }

    public String getPhoneError() {
	return phoneError;
    }

    public void setPhoneError(String phoneError) {
	this.phoneError = phoneError;
    }

    public String getSexError() {
	return sexError;
    }

    public void setSexError(String sexError) {
	this.sexError = sexError;
    }
    
    
}
