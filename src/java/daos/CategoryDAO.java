/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.CategoryDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author Khoa Nguyễn
 */
public class CategoryDAO implements Serializable{
    public ArrayList<CategoryDTO> getAllCategory() throws NamingException, SQLException{
        ArrayList<CategoryDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                String sql = "SELECT categoryID, categoryName FROM tlbCategories";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while(rs.next()){
                    String categoryID = rs.getString("categoryID");
                    String categoryName = rs.getString("categoryName");
                    list.add(new CategoryDTO(categoryID, categoryName));
                }
            }
        }finally{
            if(conn != null)
                conn.close();
            if(rs != null)
                rs.close();
            if(stm != null)
                stm.close();
        }
        return list;
    }
}
