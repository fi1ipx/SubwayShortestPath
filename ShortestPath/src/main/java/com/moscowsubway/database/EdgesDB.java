/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscowsubway.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.moscowsubway.objects.Edge;

/**
 *
 * @author Fil
 */
public class EdgesDB {
    private EdgesDB() {
    }
    private static EdgesDB instance;

    public static EdgesDB getInstance() {
        if (instance == null) {
            instance = new EdgesDB();
        }

        return instance;
    }
    
    public ArrayList<Edge> getAllEdges() {
        ArrayList<Edge> edges = new ArrayList<>();
        try {
            edges = getAllEdges(getAllEdgesStmt());
        } catch (SQLException ex) {
            Logger.getLogger(LineDB.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
            SubwayDB.getInstance().closeConnection();
        }
        return edges;
    }

    private ArrayList<Edge> getAllEdges(PreparedStatement stmt) {
        ArrayList<Edge> edges = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery();
            while (rs.next()) {
                Edge edge = new Edge(rs.getInt("st1"), rs.getInt("st2"));
                edges.add(edge);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return edges;
    }
    
    private PreparedStatement getAllEdgesStmt() throws SQLException {
        Connection conn = SubwayDB.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from edges");
        return stmt;
    }
}
