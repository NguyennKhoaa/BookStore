/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.ProductDTO;
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
public class ProductDAO implements Serializable{
    private List<ProductDTO> allProduct;

    public List<ProductDTO> getAllBooks() {
        return allProduct;
    }
    
    public ArrayList<ProductDTO> getAllProductForUser() throws SQLException, NamingException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT productID, productName,productImg, price, quantity, categoryID FROM tblProducts "
                        + "Where quantity>0";

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String productImg = rs.getString("productImg");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    list.add(new ProductDTO(productID, productName, productImg, price, quantity, categoryID));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public ArrayList<ProductDTO> getAllProductForAdmin() throws SQLException, NamingException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT productID, productName,productImg, price, quantity, categoryID FROM tblProducts";

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String productImg = rs.getString("productImg");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    list.add(new ProductDTO(productID, productName, productImg, price, quantity, categoryID));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public ArrayList<ProductDTO> searchAllProductByNameforUser(String searchValue) throws SQLException, NamingException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT productID, productName,productImg, price, quantity, categoryID FROM tblProducts WHERE productName LIKE ? "
                        + "AND quantity > 0";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + searchValue + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String productImg = rs.getString("productImg");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    list.add(new ProductDTO(productID, productName, productImg, price, quantity, categoryID));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return list;
    }
    public ArrayList<ProductDTO> searchAllProductByNameforAdmin(String searchValue) throws SQLException, NamingException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT productID, productName,productImg, price, quantity, categoryID FROM tblProducts WHERE productName LIKE ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + searchValue + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String productImg = rs.getString("productImg");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    list.add(new ProductDTO(productID, productName, productImg, price, quantity, categoryID));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return list;
    }

    public ArrayList<ProductDTO> getAllProductByCateIDforUser(String ID) throws SQLException, NamingException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT productID, productName,productImg, price, quantity, categoryID FROM tblProducts WHERE categoryID = ? "
                        + "AND quantity > 0";
                ps = con.prepareStatement(sql);
                ps.setString(1, ID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String productImg = rs.getString("productImg");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    list.add(new ProductDTO(productID, productName, productImg, price, quantity, categoryID));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return list;
    }
    public ArrayList<ProductDTO> getAllProductByCateIDforAdmin(String ID) throws SQLException, NamingException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT productID, productName,productImg, price, quantity, categoryID FROM tblProducts WHERE categoryID = ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, ID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String productImg = rs.getString("productImg");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    list.add(new ProductDTO(productID, productName, productImg, price, quantity, categoryID));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return list;
    }

    public void insertProduct(ProductDTO product) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT tblProducts VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, product.getProductID());
                ps.setString(2, product.getProductName());
                ps.setString(3, product.getProductImg());
                ps.setFloat(4, product.getPrice());
                ps.setInt(5, product.getQuantity());
                ps.setString(6, product.getCategoryID());
                ps.setString(7, product.getDescription());
                ps.setString(8, product.getAuthor());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean updateProduct(ProductDTO product) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE tblProducts SET productName = ?,productImg = ?,  price = ?, quantity = ?, categoryID = ? WHERE productID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, product.getProductName());
                ps.setString(2, product.getProductImg());
                ps.setFloat(3, product.getPrice());
                ps.setInt(4, product.getQuantity());
                ps.setString(5, product.getCategoryID());
                ps.setString(6, product.getProductID());
                int row= ps.executeUpdate();
                if(row>0){
                    return true;
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public void deleteProduct(String productID) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "DELETE FROM tblProducts WHERE productID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, productID);
                ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public String checkUpdateProduct(ProductDTO product) {
        String errorMessage = "";

        if (product.getProductName().equals("") || product.getProductName().length() < 5) {
            errorMessage += "Name is not null and length > 5\n";
        }
        if (product.getPrice() <= 0) {
            errorMessage += "Price must be > 0\n";
        }
        if (product.getQuantity() <= 0) {
            errorMessage += "Quantity must be > 0\n";
        }
        return errorMessage;
    }

    public ArrayList<String> getAllProductID() throws SQLException {
        ArrayList<String> listID = new ArrayList<String>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT productID FROM tblProducts";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    listID.add(productID);

                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listID;
    }

    public String checkCreateProduct(ProductDTO product) throws SQLException {
        ArrayList<String> listID = getAllProductID();
        Boolean check = true;
        String errorMessage = "";

        for (int i = 0; i < listID.size(); i++) {
            if (product.getProductID().equals(listID.get(i))) {
                check = false;
            }
        }

        if (!check) {
            errorMessage += "Duplicate Product ID\n";
        }
        if (product.getProductName().equals("") || product.getProductName().length() < 5) {
            errorMessage += "Name is not null and length > 5\n";
        }
        if (product.getPrice() <= 0) {
            errorMessage += "Price must be > 0\n";
        }
        if (product.getQuantity() <= 0) {
            errorMessage += "Quantity must be > 0\n";
        }
        return errorMessage;
    }

    public int getQuantityProductByID(String productID) throws SQLException, NamingException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT quantity FROM tblProducts WHERE productID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, productID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("quantity");
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return -1;
    }

    public boolean updateQuantityAfterCheckout(String productID, int quantityContain) throws SQLException, NamingException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE tblProducts SET quantity = ? "
                        + "WHERE productID = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, quantityContain);
                ps.setString(2, productID);
                int row = ps.executeUpdate();
                if (row>0) {
                    return true;
                }
            }
        } finally {
     
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }
    
    public ProductDTO getProductByID(String productID) throws NamingException, SQLException{
         Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT productID, productName,productImg, price, quantity, categoryID FROM tblProducts "
                        + "WHERE productID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, productID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String productName = rs.getString("productName");
                    String productImg = rs.getString("productImg");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    return new ProductDTO(productID, productName, productImg, price, quantity, categoryID);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
    
    public boolean updateProductQuantityByProductID(String productID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE tblProducts SET quantity = 0 WHERE productID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, productID);
                int row = ps.executeUpdate();
                if(row > 0){
                   return true;
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
