/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm.user;

/**
 *
 * @author Suki
 */
public class UserError {
   private String userIDError;
    private String fullNameError;
    private String roleIDError;
    private String phoneError;
    private String statusIDError;
    private String passwordError;
    private String confirmPasswordError;    
    private String messageError;
    
    public UserError() {
        this.userIDError = "";
        this.fullNameError = "";
        this.roleIDError = "";
        this.phoneError="";
        this.statusIDError="";       
        this.passwordError = "";
        this.confirmPasswordError = "";
        this.messageError="";
    }

    public UserError(String userIDError, String fullNameError, String roleIDError, String phoneError, String statusIDError, String passwordError, String confirmPasswordError, String messageError) {
        this.userIDError = userIDError;
        this.fullNameError = fullNameError;
        this.roleIDError = roleIDError;
        this.phoneError = phoneError;
        this.statusIDError = statusIDError;
        this.passwordError = passwordError;
        this.confirmPasswordError = confirmPasswordError;
        this.messageError = messageError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getStatusIDError() {
        return statusIDError;
    }

    public void setStatusIDError(String statusIDError) {
        this.statusIDError = statusIDError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmPasswordError() {
        return confirmPasswordError;
    }

    public void setConfirmPasswordError(String confirmPasswordError) {
        this.confirmPasswordError = confirmPasswordError;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    

    

    

}
    
