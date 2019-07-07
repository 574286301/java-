package com;

import com.utils.C3P0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelloWorld {
    public static void main( String[] args )  {

        try {
            System.out.println( "准备执行" );
            Connection conn =  C3P0Utils.getConnection();
            String sql = "select * from cxused";
            PreparedStatement data = conn.prepareStatement(sql);
           System.out.println( data );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
