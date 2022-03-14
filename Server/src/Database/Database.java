package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private String driverName = "com.mysql.cj.jdbc.Driver";
    private Connection connect;
    private Statement statemnt;

    public Database(String drivName, String url, String name, String pass) throws ClassNotFoundException, SQLException {
        this.driverName = drivName;
        Class.forName(this.driverName);
        this.connect = DriverManager.getConnection(url, name, pass);
        this.statemnt = this.connect.createStatement();
        this.statemnt.execute("set character set utf8");
        this.statemnt.execute("set names utf8");
    }

    public void insert(String sqlString) {
        try {
            statemnt.executeUpdate(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String sqlString) {
        try {
            statemnt.executeUpdate(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(String sqlString) {
        try {
            statemnt.executeUpdate(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet select(String sqlString) {
        ResultSet rs = null;
        try {
            rs = statemnt.executeQuery(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void close() {
        try {
            connect.close();
            statemnt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
