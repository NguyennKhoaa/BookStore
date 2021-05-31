/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;

/**
 *
 * @author Khoa Nguyễn
 */
public class tblDiscountDTO implements Serializable{
    private String discountID;
    private String discountDescription;
    private float percentDiscount;
    private boolean status;

    public tblDiscountDTO(String discountID) {
        this.discountID = discountID;
    }

   
    

    public tblDiscountDTO(String discountID, String discountDescription, float percentDiscount, boolean status) {
        this.discountID = discountID;
        this.discountDescription = discountDescription;
        this.percentDiscount = percentDiscount;
        this.status = status;
    }

    public String getDiscountID() {
        return discountID;
    }

    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }

    public float getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(float percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
