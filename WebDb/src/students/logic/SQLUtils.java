package students.logic;

/**
 *
 * Created by Igor Gavrilyuk on 30.10.2016.
 */
public class SQLUtils {

    /**
     * Returns sql query
     * @param table table(s) name
     * @param projection array table fields sample  String[]{last_name, first_name } or null - *(all fields)
     * @param selection selections string sample "last_name=? and  first_name=?" or null none
     * @param selectionArgs  array of selections arguments String[]{"3","name"} or null none
     * @param sortOrder sorting order string sample  first_name DESC  or null none
     * @return String build sql query (select * from student where first_name='name' AND last_name='last' ORDER BY first_name)
     */
    public static String buildSqlQuery(String table, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
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
           // System.out.println("after before:"+selection);
            sql.append(" WHERE ");
            for (String s : selectionArgs) {
                selection= selection.replaceFirst("\\?",s);
            }
           // System.out.println("after where:"+selection);
            sql.append(selection).append(" ");
        }
        if (sortOrder != null) {
            sql.append("ORDER BY").append(" ").append(sortOrder);
        }

        return sql.toString();
    }

    /**
     * Returns true if the string is null or 0-length.
     */
    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }


}
