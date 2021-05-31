/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.OrdersDetailDTO;
import java.io.Serializable;
import java.sql.Connection;
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
public class OrdersDetailDAO implements Serializable{
    public boolean insertOrderDetail(int orderID,String productID,int quantity, float price) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrderDetails(orderID, productID, quantity, price) "
                        + "VALUES(?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, orderID);
                stm.setString(2,productID);
                stm.setInt(3, quantity);
                stm.setFloat(4, price);
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
    
    public List<OrdersDetailDTO> getHistoryOrderDetailByOrderID(int orderID) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrdersDetailDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT * "
                        + "FROM tblOrderDetails "
                        + "WHERE orderID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, orderID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new OrdersDetailDTO(rs.getInt("orderDetailID"),rs.getInt("orderID"),
                            rs.getString("productID"), rs.getInt("quantity"), rs.getFloat("price")));
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
}
