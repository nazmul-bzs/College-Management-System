/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.model;

import java.sql.*;

/**
 *
 * @author Nazmul
 */
public class ConnectionUtil {
    private String username;
    private String password;
    private final String CON_STRING = "jdbc:oracle:thin:@localhost:1521:orcl";
    private Connection connection = null;
    
    public ConnectionUtil() {
        this.username = "COLLEGE_DBMS";
        this.password = "12345";
    }
    
    public ConnectionUtil(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Connection getConnection() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(CON_STRING, username, password);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return connection;
    }
    
    public void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
