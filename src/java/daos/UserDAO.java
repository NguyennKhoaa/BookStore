/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author Khoa Nguyễn
 */
public class UserDAO {
    private List<UserDTO> allUser;

    public List<UserDTO> getAllUsers() {
        return allUser;
    }
    
    public UserDTO checkLogin(String userID, String password) throws NamingException, SQLException{
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
            String sql = "SELECT name, address, phone, roleID FROM tblUsers "
                        + "WHERE userID = ? AND password = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){ 
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, name, address, phone, roleID, password);
                }
            }
        } finally {
            if(conn != null)
                conn.close();
            if(rs != null)
                rs.close();
            if(stm != null)
                stm.close();
        }
        return user;
    }
    
    public boolean insert(UserDTO user) throws SQLException, NamingException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql = "INSERT INTO tblUsers(userID, name, address, phone, roleID, password) VALUES (?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getUserID());
                stm.setString(2, user.getName());
                stm.setString(3, user.getAddress());
                stm.setString(4, user.getPhone());
                stm.setString(5, user.getRoleID());
                stm.setString(6, user.getPassword());
                check = stm.executeUpdate() == 0?false:true;
            }
        } finally {
            if(stm != null)
                stm.close();
            if(conn != null) 
                conn.close();
        }
        return check;
    }
    
    public void getAllUser() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT [userID],[name],[address],[phone], [roleID], [password] \n"
                        + "from [dbo].[tblUsers]";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    String roleID = rs.getString("roleID");
                    String password = rs.getString("password");
                    UserDTO user = new UserDTO(userID, name, address, phone, roleID, password);
                    if (allUser == null) {
                        allUser = new ArrayList<>();
                    }
                    allUser.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
