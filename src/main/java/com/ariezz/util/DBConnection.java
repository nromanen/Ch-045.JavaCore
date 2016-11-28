package com.ariezz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection {

    private static Connection connection = null;

//    for mySQL
//    private static final String user = "root";
//    private static final String password = "root";
//    private static final String url = "jdbc:mysql://localhost:3306/companydb";

//  for postgresql
    private static final String url = "jdbc:postgresql://127.0.0.1:5432/companydb";
    private static final String user = "postgres";
    private static final String password = "1123581321";


    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                //for mySQL
                //Class.forName("com.mysql.jdbc.Driver");
                //for postgreSQL
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Success!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}

