package net.students.data;

import net.students.model.Student;
import net.students.util.SqlUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * Created by Igor Gavryliuk on 25.10.2016.
 */
public class SQLContentProvider {

    private static SQLContentProvider contentProvider;
    private SQLOpenHelper dateHelper;

    static final int STUDENT = 100;
    static final int STUDENT_WITH_ID = 101;
    static final int MENTOR = 102;
    static final int MENTOR_WITH_ID = 103;
    static final int GROUP = 104;
    static final int GROUP_WITH_ID = 105;


    private SQLContentProvider() throws SQLException, ClassNotFoundException {
        dateHelper = new SQLOpenHelper(SQLConnection.getConnection());
    }

    public static SQLContentProvider getInstance() throws SQLException, ClassNotFoundException {
        if (contentProvider == null) {
            contentProvider = new SQLContentProvider();
        }
        return contentProvider;
    }


    public SQLOpenHelper getDateHelper() {
        return dateHelper;
    }


    private int uriMatcher(String uri) {
        if (uri.equalsIgnoreCase(SQLContract.StudentsEntry.TABLE_NAME)) {
            return STUDENT;
        }
        if (uri.equalsIgnoreCase(SQLContract.MentorsEntry.TABLE_NAME)) {
            return MENTOR;
        }
        if (uri.equalsIgnoreCase(SQLContract.AcademicGroupEntry.TABLE_NAME)) {
            return GROUP;
        }
        return -1;
    }

    public ResultSet query(String uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) throws SQLException {
        switch (uriMatcher(uri)) {
            case STUDENT:
                return dateHelper.query(SqlUtils.buildQuerySql(SQLContract.StudentsEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder));
            case MENTOR:
                return null;//dateHelper.loadMentors(projection,selection,selectionArgs,sortOrder);
            case GROUP:
                return null;//dateHelper.loadGroups(projection,selection,selectionArgs,sortOrder);
        }
        return null;
    }


    public int insert(String uri, ContentValues value) throws SQLException {
        int rowsInserted;
        switch (uriMatcher(uri)) {
            case STUDENT:
                rowsInserted = dateHelper.insert(SQLContract.StudentsEntry.TABLE_NAME, null, value);
                if ( rowsInserted< 0 )
                    throw new SQLException("Failed to insert row into " + uri);
                break;
            case MENTOR:
                rowsInserted = dateHelper.insert(SQLContract.MentorsEntry.TABLE_NAME, null, value);
                if ( rowsInserted< 0 )
                    throw new SQLException("Failed to insert row into " + uri);
                break;
            case GROUP:
                rowsInserted = dateHelper.insert(SQLContract.AcademicGroupEntry.TABLE_NAME, null, value);
                if ( rowsInserted< 0 )
                    throw new SQLException("Failed to insert row into " + uri);
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);

        }
        return rowsInserted;
    }


    public int delete(String uri, String selection, String[] selectionArgs) throws SQLException {
        int rowsDeleted;
        switch (uriMatcher(uri)) {
            case STUDENT:
                rowsDeleted = dateHelper.delete(SQLContract.StudentsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case MENTOR:
                rowsDeleted = dateHelper.delete(SQLContract.MentorsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case GROUP:
                rowsDeleted = dateHelper.delete(SQLContract.AcademicGroupEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);

        }
        return rowsDeleted;
    }


    public int update(String uri, ContentValues cv , String selection, String[] selectionArgs) throws SQLException {
        int rowsUpdated;
        switch (uriMatcher(uri)) {
            case STUDENT:
                rowsUpdated = dateHelper.update(SQLContract.StudentsEntry.TABLE_NAME, cv, selection, selectionArgs);
                break;
            case MENTOR:
                rowsUpdated = dateHelper.update(SQLContract.MentorsEntry.TABLE_NAME, cv, selection, selectionArgs);
                break;
            case GROUP:
                rowsUpdated = dateHelper.update(SQLContract.AcademicGroupEntry.TABLE_NAME, cv, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);

        }
        return rowsUpdated;
    }



}
