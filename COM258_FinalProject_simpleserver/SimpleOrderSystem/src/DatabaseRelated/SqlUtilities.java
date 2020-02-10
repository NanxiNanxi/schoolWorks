/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseRelated;

/**
 *
 * @author zhou6718
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlUtilities {
    public static void main(String[] args) {
        SqlUtilities squ = new SqlUtilities();
        squ.insertIntoGoods(new goods(1, "testname", "testDesc", "testCate", 5, 3, "testPath"));
    }

    public Connection getConnection() {
        Connection conn = null;
        String url = "*********";


        try {
       
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return conn;
    }

    public void deleteGoods(goods g) {
        Connection con = getConnection();
        String sqlCommand = "DELETE FROM Goods WHERE GoodsId =?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlCommand);
            pstmt.setInt(1, g.getId());
            pstmt.executeUpdate();
            pstmt.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(SqlUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertIntoGoods(goods g) {
        Connection con = getConnection();
        String sqlCommand = "INSERT INTO Goods (GoodsId,GoodsName,Description,Category,Price,StockNumber,PicPath) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlCommand);
            pstmt.setInt(1, g.getId());
            pstmt.setString(2, g.getName());
            pstmt.setString(3, g.getDescription());
            pstmt.setString(4, g.getCategory());
            pstmt.setFloat(5, g.getPrice());
            pstmt.setInt(6, g.getInStock());
            pstmt.setString(7, g.getPicPath());

            pstmt.executeUpdate();
            pstmt.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(SqlUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UpdateGoods(goods g) {
        Connection con = getConnection();
        String sqlCommand = "UPDATE Goods SET GoodsId=?,GoodsName=?,Description=?,Category=?,Price=?,StockNumber=?,PicPath=?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlCommand);
            pstmt.setInt(1, g.getId());
            pstmt.setString(2, g.getName());
            pstmt.setString(3, g.getDescription());
            pstmt.setString(4, g.getCategory());
            pstmt.setFloat(5, g.getPrice());
            pstmt.setInt(6, g.getInStock());
            pstmt.setString(7, g.getPicPath());

            pstmt.executeUpdate();
            pstmt.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(SqlUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertIntoUsers(users u) {
        Connection con = getConnection();
        String sqlCommand = "INSERT INTO Users (UserId,Account,Password,AccessLevel,PhoneNumber,Address) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlCommand);
            pstmt.setInt(1, u.getUserId());
            pstmt.setString(2, u.getAccount());
            pstmt.setString(3, u.getPassword());
            pstmt.setString(4, u.getAccessLevel());
            pstmt.setString(5, u.getPhoneNumber());
            pstmt.setString(6, u.getAddress());

            pstmt.executeUpdate();
            pstmt.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(SqlUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateUsers(users u) {
        Connection con = getConnection();
        String sqlCommand = "UPDATE Users SET UserId=?,Account=?,Password=?,AccessLevel=?,PhoneNumber=?,Address=?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlCommand);
            pstmt.setInt(1, u.getUserId());
            pstmt.setString(2, u.getAccount());
            pstmt.setString(3, u.getPassword());
            pstmt.setString(4, u.getAccessLevel());
            pstmt.setString(5, u.getPhoneNumber());
            pstmt.setString(6, u.getAddress());

            pstmt.executeUpdate();
            pstmt.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(SqlUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertIntoOrderDetails(orderDetails o) {
        Connection con = getConnection();
        String sqlCommand = "INSERT INTO OrederDetails (OrderId,UserId,GoodsId,GoodsNumber,IsShipped) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlCommand);
            pstmt.setInt(1, o.getOrderId());
            pstmt.setInt(2, o.getUserId());
            pstmt.setInt(3, o.getGoodsId());
            pstmt.setInt(4, o.getGoodsNumber());
            pstmt.setString(5, o.getIsShipped());

            pstmt.executeUpdate();
            pstmt.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(SqlUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateOrderDetails(orderDetails o) {
        Connection con = getConnection();
        String sqlCommand = "UPDATE OrederDetails set OrderId=?,UserId=?,GoodsId=?,GoodsNumber=?,IsShipped=?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlCommand);
            pstmt.setInt(1, o.getOrderId());
            pstmt.setInt(2, o.getUserId());
            pstmt.setInt(3, o.getGoodsId());
            pstmt.setInt(4, o.getGoodsNumber());
            pstmt.setString(5, o.getIsShipped());

            pstmt.executeUpdate();
            pstmt.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(SqlUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
