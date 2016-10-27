package net.students.data;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.*;
import java.util.logging.Logger;

/**
 *
 * Created by Igor Gavryliuk on 25.10.2016.
 */
public class SQLOpenHelper {

    private static final Logger LOGGER = Logger.getLogger(SQLOpenHelper.class.getName());

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private static DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");

    public SQLOpenHelper(Connection connection) throws SQLException {
        LOGGER.info("Creating statement...");
        if (connection != null) {
            this.connection = connection;
            this.statement = connection.createStatement();
        }

    }

    private static String buildQuerySql(String table, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        StringBuilder sql= new StringBuilder();
        sql.append("SELECT").append(" ");
        if (projection != null) {
            for (int i = 0; i < projection.length; i++) {
                if (i == (projection.length - 1)) {
                    sql.append(projection[i]);// no add , if last element
                } else sql.append(projection[i]).append(",");
            }
        } else sql.append("*");
        sql.append(" ");
        sql.append("FROM").append(" ");
        sql.append(table).append(" ");
        if (selection != null && selectionArgs != null) {
            System.out.println("after before:"+selection);
            sql.append(" WHERE ");
            for (String s : selectionArgs) {
                selection= selection.replaceFirst("\\?",s);
            }
            System.out.println("after where:"+selection);
            sql.append(selection).append(" ");
        }
        if (sortOrder != null) {
            sql.append("ORDER BY").append(" ").append(sortOrder);
        }

        return sql.toString();
    }

    public int insert(String table, String nullColumnHack, ContentValues initialValues) throws SQLException {
        int result = -1;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT");
        sql.append(" INTO ");
        sql.append(table);
        sql.append('(');
        Object[] bindArgs = null;
        int size = (initialValues != null && initialValues.size() > 0)
                ? initialValues.size() : 0;
        if (size > 0) {
            bindArgs = new Object[size];
            int i = 0;
            for (String colName : initialValues.keySet()) {
                sql.append((i > 0) ? "," : "");
                sql.append(colName);
                bindArgs[i++] = initialValues.get(colName);
            }
            sql.append(')');
            sql.append(" VALUES (");
            for (i = 0; i < size; i++) {
                //sql.append((i > 0) ? ",?" : "?");
                if (bindArgs[i] instanceof String || bindArgs[i] instanceof Date) {
                    sql.append((i > 0) ? "," + "'" + bindArgs[i].toString() + "'" : "'"+bindArgs[i].toString() + "'");
                } else {
                    sql.append((i > 0) ? "," + bindArgs[i].toString() : bindArgs[i].toString());
                }

            }
        } else {
            sql.append(nullColumnHack + ") VALUES (NULL");
        }
        sql.append(')');
        LOGGER.info("insert sql="+sql.toString());
        result = statement.executeUpdate(sql.toString());
        return result;
    }

    public int delete(String table, String selection, String[] selectionArgs) throws SQLException {
        int count ;
        String sql = "DELETE FROM " + table;
        if (selection != null && selectionArgs != null) {
            sql+=" WHERE ";
            for (String s : selectionArgs) {
                selection= selection.replaceFirst("\\?",s);
            }
            sql += " " + selection;
        }
        LOGGER.info("delete sql="+sql);
        count = statement.executeUpdate(sql);
        return count;
    }

    public  int  update(String table, ContentValues values, String whereClause, String[] whereArgs) throws SQLException {
        int count = -1;
        if (values == null || values.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
         String sql = "UPDATE "+table+" SET "+ values.toString();
            if (whereClause != null && whereArgs != null) {
                for (String s : whereArgs) {
                    whereClause = whereClause.replaceFirst("\\?", s);
                }
                sql += " " + whereClause;
            }
        // create the java mysql update
        count =  statement.executeUpdate(sql);
        return count;
    }

    public ResultSet query(String sqlQuery) throws SQLException {
        return statement.executeQuery(sqlQuery);
    }

    public Statement getStatement() {
        return statement;
    }
    public Connection getConnection() {
        return connection;
    }





}
