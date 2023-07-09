/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem.pojo;

/**
 *
 * @author Soft1
 */
public class UserPojo {

    private String password;
    private String userType;
    private String userName;
    private String loginId;

    public UserPojo(String password, String userType, String userName, String loginId) {
        this.password = password;
        this.userType = userType;
        this.userName = userName;
        this.loginId = loginId;
    }

    public UserPojo() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Override
    public String toString() {
        return "UserPojo{" + "password=" + password + ", userType=" + userType + ", userName=" + userName + ", loginId=" + loginId + '}';
    }
    
    
}
