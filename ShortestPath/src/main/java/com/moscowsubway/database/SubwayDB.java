/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscowsubway.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SubwayDB {

    private static Connection conn;
    private static InitialContext ic;
    private static DataSource ds;

    private SubwayDB() {
    }
    private static SubwayDB instance;

    public static SubwayDB getInstance() {
        if (instance == null) {
            instance = new SubwayDB();
        }

        return instance;
    }

    public Connection getConnection() {

        try {
            if (conn == null || conn.isClosed()) {
                ic = new InitialContext();
                ds = (DataSource) ic.lookup("jdbc/Subway");
                conn = ds.getConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubwayDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SubwayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();


            } catch (SQLException ex) {
                Logger.getLogger(SubwayDB.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}