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
import com.moscowsubway.objects.Station;

public class StationDB {

    private StationDB() {
    }
    private static StationDB instance;

    public static StationDB getInstance() {
        if (instance == null) {
            instance = new StationDB();
        }

        return instance;
    }

    public Station getStation(int id) {
        try {
            return getStation(getStationStmt(id));
        } catch (SQLException ex) {
            Logger.getLogger(StationDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            SubwayDB.getInstance().closeConnection();
        }
        return null;
    }

    public Station getStation(String name) {
        try {
            return getStation(getStationStmt(name));
        } catch (SQLException ex) {
            Logger.getLogger(StationDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            SubwayDB.getInstance().closeConnection();
        }
        return null;
    }

    public ArrayList<Station> getAllStations() {
        ArrayList<Station> stations = new ArrayList<>();
        try {
            stations = getAllStations(getAllStationsStmt());
        } catch (SQLException ex) {
            Logger.getLogger(LineDB.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
            SubwayDB.getInstance().closeConnection();
        }
        return stations;
    }

    private ArrayList<Station> getAllStations(PreparedStatement stmt) {
        ArrayList<Station> stations = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery();
            while (rs.next()) {
                Station station = new Station();
                station.setId(rs.getInt("id"));
                station.setLineNum(rs.getInt("line_id"));
                station.setName(rs.getString("name"));
                stations.add(station);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stations;
    }
    
    private Station getStation(PreparedStatement stmt) {

        Station st = null;
        ResultSet rs = null;

        try {
            rs = stmt.executeQuery();

            rs.next();
            if (rs.isFirst()) {
                st = new Station();
                st.setId(rs.getInt("id"));
                st.setLineNum(rs.getInt("line_id"));
                st.setName(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return st;
    }

    private PreparedStatement getStationStmt(String name) throws SQLException {
        Connection conn = SubwayDB.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from stations where name=?");
        stmt.setString(1, name);
        return stmt;
    }

    private PreparedStatement getAllStationsStmt() throws SQLException {
        Connection conn = SubwayDB.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from stations");
        return stmt;
    }
    
    private PreparedStatement getStationStmt(int id) throws SQLException {
        Connection conn = SubwayDB.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from stations where id=?");
        stmt.setInt(1, id);
        return stmt;
    }
}

