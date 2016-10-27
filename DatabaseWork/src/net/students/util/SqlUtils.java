package net.students.util;

/**
 * Sql Utils
 * Created by GipSoft on 10/27/2016.
 */
public class SqlUtils {

    public static String buildQuerySql(String table, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
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
}
