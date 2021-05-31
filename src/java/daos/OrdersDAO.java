/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.OrdersDTO;
import dtos.OrdersDetailDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author Khoa Nguyễn
 */
public class OrdersDAO implements Serializable {

    public boolean insertOrder(String userID,String discountID, Date createDate, float totalPrice) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrders(userID, discountID, date, total) "
                        + "VALUES(?, ?, ?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, discountID);
                stm.setDate(3, createDate);
                stm.setFloat(4, totalPrice);
                //
                int row = stm.executeUpdate();
                if (row > 0) {
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

    public int getLastRecord() throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT orderID FROM tblOrders ORDER BY orderID DESC";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getInt("orderID");
                }
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return -1;
    }

    public boolean deleteOrder(int orderID) throws NamingException, SQLException {

        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM tblOrders WHERE orderID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, orderID);
                int row = stm.executeUpdate();
                if (row > 0) {
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

    public List<OrdersDTO> getHistoryByUser(String userID) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrdersDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT * "
                        + "FROM tblOrders "
                        + "WHERE tblOrders.userID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    OrdersDTO a = new OrdersDTO(rs.getInt("orderID"), userID, rs.getDate("date"), rs.getFloat("total"));
                    list.add(a);
                }
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }
    public List<OrdersDetailDTO> getDetailHistory(int orderID) throws NamingException, SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        OrdersDetailDTO a = null;
        List<OrdersDetailDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT orderDetailID, orderID, productID, price, quantity FROM tblOrderDetails where orderID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, orderID);
                rs= stm.executeQuery();
                while (rs.next()) {
                    a = new OrdersDetailDTO(rs.getInt("orderDetailID"), orderID, rs.getString("productID"), Integer.parseInt("quantity"), Float.parseFloat("price"));
                    list.add(a);
                }
            }
        }finally {
            if (conn != null) {
                conn.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
            }
        return list;
    }
}
