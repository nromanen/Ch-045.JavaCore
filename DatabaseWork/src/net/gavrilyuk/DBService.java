package net.gavrilyuk;

import java.sql.*;

/**
 *
 * Created by GipSoft on 10/24/2016.
 */
public class DBService {


    public static void main(String[] args) {
        DBHelper dbHelper = null;
        try{
            dbHelper = DBHelper.getInstance();

            System.out.println(dbHelper.getStudents());
            System.out.println(dbHelper.getMentor());
            System.out.println(dbHelper.getAcademicGroup());

        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if (dbHelper != null) {
                    if(dbHelper.getDateReader().getStmt()!=null)
                        dbHelper.getDateReader().getConnection().close();
                }
            }catch(SQLException ignored){
            }// do nothing
            try{
                if (dbHelper != null) {
                    if(dbHelper.getDateReader().getConnection()!=null)
                        dbHelper.getDateReader().getConnection().close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main

}
