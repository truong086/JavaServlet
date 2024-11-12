/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Bac Viet PC
 */
public class DBContext {
    public static Connection getConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String urrl = "jdbc:mysql://localhost:3306/quanlyquantrasua"; 
        String user = "root";
        String pass = "root";
        Connection conn = DriverManager.getConnection(urrl, user, pass);
        return conn;
        
    }
    
    public static void main(String[] args) {
        try{
            System.out.println("Kết nối thành công " + getConnection());
        }catch(Exception e){
            System.out.println("Lỗi ");
            e.printStackTrace();
        }
    }
}
