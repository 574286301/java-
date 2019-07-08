package com;

import com.utils.C3P0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloWorld {
    public static void main( String[] args )  {
        Connection conn = null;
        PreparedStatement data = null;
        ResultSet rs = null;
        try {
            System.out.println( "准备执行" );
            conn =  C3P0Utils.getConnection();
            String sql = "select count(*) from t_news";
            data = conn.prepareStatement(sql);
            rs = data.executeQuery();
            if(rs.next()){
                Long count = rs.getLong(1);
                System.out.println( count );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn != null){
                        conn.close();
                }
                if(data != null){
                    data.close();
                }
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
