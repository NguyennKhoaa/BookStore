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
public class UserDTO implements Serializable{
    private String userID;
    private String name;
    private String address;
    private String phone;
    private String roleID;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String userID, String name, String address, String phone, String roleID, String password) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.roleID = roleID;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", name=" + name + ", address=" + address + ", phone=" + phone + ", roleID=" + roleID + ", password=" + password + '}';
    }
}
