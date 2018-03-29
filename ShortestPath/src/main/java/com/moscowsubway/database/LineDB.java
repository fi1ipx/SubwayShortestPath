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
import java.util.logging.Level;
import java.util.logging.Logger;
import com.moscowsubway.objects.Line;


public class LineDB {

    private LineDB() {
    }
    private static LineDB instance;

    public static LineDB getInstance() {
        if (instance == null) {
            instance = new LineDB();
        }

        return instance;
    }

    public Line getLine(int id) {
        try {
            return getLine(getLineStmt(id));
        } catch (SQLException ex) {
            Logger.getLogger(LineDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            SubwayDB.getInstance().closeConnection();
        }
        return null;
    }

    public Line getLine(String name) {
        try {
            return getLine(getLineStmt(name));
        } catch (SQLException ex) {
            Logger.getLogger(LineDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            SubwayDB.getInstance().closeConnection();
        }
        return null;
    }
    
    public ArrayList<Line> getAllLines() {
        ArrayList<Line> lines = new ArrayList<>();
        try {
            lines = getAllLines(getAllLinesStmt());
        } catch (SQLException ex) {
            Logger.getLogger(LineDB.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
            SubwayDB.getInstance().closeConnection();
        }
        return lines;
    }

    private ArrayList<Line> getAllLines(PreparedStatement stmt) {
        ArrayList<Line> lines = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery();
            while (rs.next()) {
                Line line = new Line();
                line.setId(rs.getInt("id"));
                line.setLineNum(rs.getInt("line_num"));
                line.setName(rs.getString("name"));
                lines.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
    
    private Line getLine(PreparedStatement stmt) {

        Line line = null;
        ResultSet rs = null;

        try {
            rs = stmt.executeQuery();

            rs.next();
            if (rs.isFirst()) {
                line = new Line();
                line.setId(rs.getInt("id"));
                line.setLineNum(rs.getInt("line_num"));
                line.setName(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return line;
    }

    private PreparedStatement getLineStmt(String name) throws SQLException {
        Connection conn = SubwayDB.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from subway_lines where name=?");
        stmt.setString(1, name);
        return stmt;
    }
    
    private PreparedStatement getAllLinesStmt() throws SQLException {
        Connection conn = SubwayDB.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from subway_lines");
        return stmt;
    }

    private PreparedStatement getLineStmt(int id) throws SQLException {
        Connection conn = SubwayDB.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from subway_lines where id=?");
        stmt.setInt(1, id);
        return stmt;
    }
}
