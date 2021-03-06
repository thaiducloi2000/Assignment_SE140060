/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.UserDTO;
import DTO.UserGoogole;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author PC
 */
public class UserDAO {

    public UserDTO checkLogin(String userID, String password) throws SQLException {
	UserDTO user = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "Select userID,userName,roleID FROM tblUsers "
			+ " WHERE userID = '" + userID + "' AND password = '" + password + "'";
		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();
		if (rs.next()) {
		    String userName = rs.getString("userName");
		    String roleID = rs.getString("roleID");
		    user = new UserDTO(userID, userName, "", "", "", "", roleID);
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return user;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
	List<UserDTO> listUser = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT userID,userName,address,phone,sex,roleID"
			+ " FROM tblUsers "
			+ " WHERE userName LIKE '%" + search + "%'";
		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();
		while (rs.next()) {
		    String userID = rs.getString("userID");
		    String userName = rs.getString("userName");
		    String address = rs.getString("address");
		    String phone = rs.getString("phone");
		    String sex = rs.getString("sex");
		    String roleID = rs.getString("roleID");
		    UserDTO user = new UserDTO(userID, userName, phone, address, phone, sex, roleID);
		    if (listUser == null) {
			listUser = new ArrayList<>();
		    }
		    listUser.add(user);
		}
	    }
	} catch (Exception e) {
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return listUser;
    }

    public boolean Delete(String userID) throws SQLException {
	boolean check = false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "DELETE tblUsers "
			+ "WHERE userID='" + userID + "'";
		stm = conn.prepareStatement(sql);
		check = stm.executeUpdate() > 0 ? true : false;
	    }
	} catch (Exception e) {
	} finally {
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return check;
    }

    public boolean Update(UserDTO dto) throws SQLException {
	boolean check = false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "UPDATE tblUsers SET "
			+ " userName='" + dto.getUserName() + "', "
			+ " address='" + dto.getAddress() + "', "
			+ " phone='" + dto.getPhone() + "', "
			+ " sex='" + dto.getSex() + "'"
			+ " WHERE userID='" + dto.getUserID() + "'";
		stm = conn.prepareStatement(sql);
		check = stm.executeUpdate() > 0 ? true : false;
	    }
	} catch (Exception e) {
	} finally {
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return check;
    }

    public boolean Insert(UserDTO user) throws SQLException {
	boolean check = false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "INSERT INTO tblUsers(userID,userName,password,address,phone,sex,roleID) "
			+ " Values (?,?,?,?,?,?,?)";
		stm = conn.prepareStatement(sql);
		stm.setString(1, user.getUserID());
		stm.setString(2, user.getUserName());
		stm.setString(3, user.getPassword());
		stm.setString(4, user.getAddress());
		stm.setString(5, user.getPhone());
		stm.setString(6, user.getSex());
		stm.setString(7, user.getRoleID());
		check = stm.executeUpdate() > 0 ? true : false;
	    }
	} catch (Exception e) {
	} finally {
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return check;
    }

    public static String getToken(final String code) throws ClientProtocolException, IOException {
	String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
		.bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
			.add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
			.add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
			.add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
		.execute().returnContent().asString();
	JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
	String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
	return accessToken;
    }

    public static UserGoogole getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
	String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
	String response = Request.Get(link).execute().returnContent().asString();
	UserGoogole googlePojo = new Gson().fromJson(response, UserGoogole.class);
	System.out.println(googlePojo);
	return googlePojo;
    }
}
