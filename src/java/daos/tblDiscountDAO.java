/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.UserDTO;
import dtos.tblDiscountDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author Khoa Nguyễn
 */
public class tblDiscountDAO implements Serializable {

    public boolean checkDiscountIDforCustomer(String discountID) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT discountID, discountDescription, percentDiscount FROM tblDiscount "
                        + "WHERE discountID = ? AND status = 1";
                stm = conn.prepareStatement(sql);
                stm.setString(1, discountID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
        }
        return false;
    }

    public boolean checkDiscountIDforAdmin(String discountID) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT discountID, discountDescription, percentDiscount FROM tblDiscount "
                        + "WHERE discountID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, discountID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
        }
        return false;
    }

    public tblDiscountDTO getDiscountByDiscountID(String discountID) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT discountID, discountDescription, percentDiscount,status FROM tblDiscount "
                        + "WHERE discountID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, discountID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return new tblDiscountDTO(rs.getString("discountID"), rs.getString("discountDescription"),
                            rs.getFloat("percentDiscount"), rs.getBoolean("status"));
                }
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
        }
        return null;
    }

    public boolean updateStatusFalseDiscountID(String discountID) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblDiscount "
                        + "SET status = 0 WHERE discountID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, discountID);
                
                int rs = stm.executeUpdate();
                if (rs > 0) {
                    return true;
                }
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        
            if (stm != null) {
                stm.close();
            }
        }
        return false;
    }
    
    public boolean insertNewDiscount(String discountID, String descriptionDiscount, float percentDiscount) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblDiscount(discountID, discountDescription, percentDiscount,status) "
                        + "VALUES(?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, discountID);
                stm.setString(2, descriptionDiscount);
                stm.setFloat(3, percentDiscount);
                stm.setBoolean(4, true);
                
                int rs = stm.executeUpdate();
                if (rs > 0) {
                    return true;
                }
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        
            if (stm != null) {
                stm.close();
            }
        }
        return false;
    }
    
    

}
