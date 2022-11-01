package util;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {
    private static PreparedStatement execute(String sql,Object... params) throws SQLException, ClassNotFoundException {
        Connection con= DBConnection.getInstance().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        for (int i=0; i<params.length; i++){
            stm.setObject((i+1),params[i]);
        }
        return stm;
    }

    public static ResultSet executeQuery(String sql, Object... params) throws SQLException, ClassNotFoundException {
        return execute(sql,params).executeQuery();
    }

    public static Boolean executeUpdate(String sql, Object... params) throws SQLException, ClassNotFoundException {
        return execute(sql,params).executeUpdate()>0;
    }

}
