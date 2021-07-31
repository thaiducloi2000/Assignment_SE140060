/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PC
 */
public class CartDTO {
    private Map<String,ProductDTO> cart;
    private float total=0;

    public CartDTO() {
    }

    public CartDTO(Map<String, ProductDTO> cart) {
	this.cart = cart;
    }

    public Map<String, ProductDTO> getCart() {
	return cart;
    }

    public void setCart(Map<String, ProductDTO> cart) {
	this.cart = cart;
    }
    
    public void add(ProductDTO pro){
	if(this.cart==null){
	    this.cart=new HashMap<String, ProductDTO>();
	}
	if(this.cart.containsKey(pro.getProID())){
	    int quantity=this.cart.get(pro.getProID()).getQuantity();
	    pro.setQuantity(quantity+1);
//	    tea.setQuantity(quantity+tea.getQuantity()); an gian
	}
	cart.put(pro.getProID(), pro);
    }
    
    public void delete(String id){
	if(this.cart==null){
	    return;
	}
	if(this.cart.containsKey(id)){
	    this.cart.remove(id);
	}
    }
    
    public void update(String id,ProductDTO tea){
	if(this.cart== null){
	    return;
	}
	if(this.cart.containsKey(id)){
	    this.cart.replace(id, tea);
	}
    } 
}
