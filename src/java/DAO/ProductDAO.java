/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ProductDAO {

    public List<ProductDTO> getListProduct(String search) throws SQLException {
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	List<ProductDTO> list = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT productID,productName,price,imageProduct "
			+ " FROM tblProducts "
			+ " WHERE status = 1 AND productName LIKE '%" + search + "%'";
		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();
		while (rs.next()) {
		    String productID=rs.getString("productID");
		    String productName=rs.getString("productName");
		    float price=Float.parseFloat(rs.getString("price"));
		    String image=rs.getString("imageProduct");
		    ProductDTO product=new ProductDTO(productID, productName, price, 0, image, true, "");
		    if (list==null) {
			list=new ArrayList<>();
		    }
		    list.add(product);
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
    public List<ProductDTO> getListAllProduct() throws SQLException {
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	List<ProductDTO> list = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT productID,productName,price,imageProduct "
			+ " FROM tblProducts "
			+ " WHERE status = 1 AND productName LIKE '%%'";
		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();
		while (rs.next()) {
		    String productID=rs.getString("productID");
		    String productName=rs.getString("productName");
		    float price=Float.parseFloat(rs.getString("price"));
		    String image=rs.getString("imageProduct");
		    ProductDTO product=new ProductDTO(productID, productName, price, 0, image, true, "");
		    if (list==null) {
			list=new ArrayList<>();
		    }
		    list.add(product);
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
