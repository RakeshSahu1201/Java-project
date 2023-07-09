/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.tech.utils;

/**
 *
 * @author spsub
 */
public class UserProfile {
	private static String userName;
	private static int userId;
	private static String userType;

	public static int getUserId() {
		return userId;
	}

	public static void setUserId(int userId) {
		UserProfile.userId = userId;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		UserProfile.userName = userName;
	}

	public static String getUserType() {
		return userType;
	}

	public static void setUserType(String userType) {
		UserProfile.userType = userType;
	}

}
