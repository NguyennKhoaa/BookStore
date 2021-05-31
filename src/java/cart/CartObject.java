/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import dtos.ProductDTO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Khoa Nguyễn
 */
public class CartObject implements Serializable{
    private Map<String, ProductDTO> cartProduct = new HashMap<>();
    public Map<String, ProductDTO> getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(Map<String, ProductDTO> cartProduct) {
        this.cartProduct = cartProduct;
    }
 
    public void addTocart(ProductDTO dto) {
        if(cartProduct==null){
            cartProduct = new HashMap<>();
        }
        if (cartProduct.containsKey(dto.getProductID())) {
            dto.setQuantity(cartProduct.get(dto.getProductID()).getQuantity() + 1);
        }
        cartProduct.put(dto.getProductID(), dto);
    }

    public void removeProductFormCart(String productID) {
        if (cartProduct != null) { 
            cartProduct.remove(productID);
            if (cartProduct.isEmpty()) {
                cartProduct = null;
            }
        }
    }
}
