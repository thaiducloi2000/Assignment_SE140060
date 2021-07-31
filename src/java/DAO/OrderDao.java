/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.OrderDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class OrderDao {
    public void insertOrder(OrderDTO order) throws SQLException{
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "INSERT INTO tblOders(orderID,orderDate,total,userID)"
			+ " Values (?,?,?,?)";
		stm = conn.prepareStatement(sql);
		stm.setString(1, order.getOrderID());
		stm.setDate(2, order.getOrderDate());
		stm.setInt(3, order.getTotal());
		stm.setString(4, order.getUserID());
		stm.executeQuery();
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
    }
    
    public List<OrderDTO> getListOrder() throws SQLException{
	List<OrderDTO> list=null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT orderID,userID,orderDate,total "
			+ " FROM tblOders ";
		stm = conn.prepareStatement(sql);		
		rs = stm.executeQuery();
		while (rs.next()) {
		    String orderID=rs.getString("orderID");
		    Date orderDate=rs.getDate("orderDate");
		    int total=rs.getInt("total");
		    String userID=rs.getString("userID");
		    if(list==null){
			list=new ArrayList<>();
		    }
		    list.add(new OrderDTO(orderID, orderDate, total, userID));
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
	return list;
    }
}
