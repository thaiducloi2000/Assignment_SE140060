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
public class ProductDTO {
    private String proID;
    private String proName;
    private float proPrice;
    private int quantity;
    private String img;
    private boolean status;
    private String cateID;

    public ProductDTO() {
    }

    public ProductDTO(String proID, String proName, float proPrice, int quantity, String img, boolean status, String cateID) {
	this.proID = proID;
	this.proName = proName;
	this.proPrice = proPrice;
	this.quantity = quantity;
	this.img = img;
	this.status = status;
	this.cateID = cateID;
    }

    public String getProID() {
	return proID;
    }

    public void setProID(String proID) {
	this.proID = proID;
    }

    public String getProName() {
	return proName;
    }

    public void setProName(String proName) {
	this.proName = proName;
    }

    public float getProPrice() {
	return proPrice;
    }

    public void setProPrice(float proPrice) {
	this.proPrice = proPrice;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    public String getImg() {
	return img;
    }

    public void setImg(String img) {
	this.img = img;
    }

    public boolean isStatus() {
	return status;
    }

    public void setStatus(boolean status) {
	this.status = status;
    }

    public String getCateID() {
	return cateID;
    }

    public void setCateID(String cateID) {
	this.cateID = cateID;
    }
    
    
}
