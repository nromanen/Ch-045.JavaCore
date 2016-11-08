package net.students.dao;

import net.students.model.AcademicGroup;
import net.students.model.Mentor;
import net.students.model.Student;
import net.students.model.UserAccount;
import org.joda.time.DateTime;
import net.students.dao.SQLContract.StudentsEntry;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.*;

/**
 * SQL Utils class
 * Created by Igor Gavrilyuk on 06.11.2016.
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

            sql.append(" WHERE ");
            for (String s : selectionArgs) {
                selection= selection.replaceFirst("\\?",s);
            }

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
        return str == null || str.length() == 0;
    }

    //fill filter query data
    public static String  buildSelectionFormFilter(HttpServletRequest request ) {
        String selection ;
        String firstName = request.getParameter("firstName");
        String lastName  = request.getParameter("lastName");
        String testBookNum = request.getParameter("testBookNumber");
        String  groupId = request.getParameter("groupId");

        Map<String,String> selections = new LinkedHashMap<>();
        if (!SQLUtils.isEmpty(testBookNum)) {
            selections.put(StudentsEntry.COL_BOOK_NUM, testBookNum);
        }
        if (!SQLUtils.isEmpty(firstName) ) {
            selections.put(StudentsEntry.COL_FIRST_NAME,"'" + firstName + "%'");
        }
        if (!SQLUtils.isEmpty(lastName) ) {
            selections.put(StudentsEntry.COL_LAST_NAME,"'" + lastName + "%'");
        }
        if (!SQLUtils.isEmpty(groupId)) {
            selections.put(StudentsEntry.COL_GROUP_ID, groupId);
        }
        int i = 1;
        StringBuilder selectionBuilder = new StringBuilder();
        for (String s : selections.keySet()) {
            if (i < selections.size() && selections.size() > 1) {
                if (s.equalsIgnoreCase(StudentsEntry.COL_FIRST_NAME) || (s.equalsIgnoreCase(StudentsEntry.COL_LAST_NAME))) {
                    selectionBuilder.append(s).append(" LIKE ? AND ");
                } else selectionBuilder.append(s).append(" = ? AND ");
            } else {
                if (s.equalsIgnoreCase(StudentsEntry.COL_FIRST_NAME) || (s.equalsIgnoreCase(StudentsEntry.COL_LAST_NAME))) {
                    selectionBuilder.append(s).append(" LIKE ? ");
                } else selectionBuilder.append(s).append("  = ? ");
            }
            i++;
        }

        selection = selectionBuilder.length() > 0 ? selectionBuilder.toString() : null;
        System.out.println("selection=" + selection);
        return selection;
    }

    public static String[] buildSelectionArgsFilter(HttpServletRequest request) {

        String[] selectionArgs;
        String firstName = request.getParameter("firstName");
        String lastName  = request.getParameter("lastName");
        String testBookNum = request.getParameter("testBookNumber");
        String  groupId = request.getParameter("groupId");

        Map<String,String> selections = new LinkedHashMap<>();
        if (!SQLUtils.isEmpty(testBookNum)) {
            selections.put(SQLContract.StudentsEntry.COL_BOOK_NUM, testBookNum);
        }
        if (!SQLUtils.isEmpty(firstName) ) {
            selections.put(SQLContract.StudentsEntry.COL_FIRST_NAME,"'" + firstName + "%'");
        }
        if (!SQLUtils.isEmpty(lastName) ) {
            selections.put(SQLContract.StudentsEntry.COL_LAST_NAME,"'" + lastName + "%'");
        }
        if (!SQLUtils.isEmpty(groupId)) {
            selections.put(SQLContract.StudentsEntry.COL_GROUP_ID, groupId);
        }

        selectionArgs = selections.values().toArray(new String[selections.size()]);
        // debug
        /*for (String selectionArg : selectionArgs) {
            System.out.println("Selection Arg="+selectionArg);
        }*/
        return selectionArgs;
    }

    // For test database: populate data
    // insert 25 academic groups
    // insert 25 mentors
    // insert 800 students
    public static void populateData(SQLDBProvider provider) {
        Random random = new Random();
        try {
            for (int i = 0; i < 25; i++) {
                AcademicGroup group = new AcademicGroup();
                group.setTitle("Academic Group " + i);
                provider.insert(SQLContract.AcademicGroupEntry.TABLE_NAME, group);
            }
            for (int i = 0; i < 25; i++) {
                Mentor mentor = new Mentor();
                mentor.setFirstName("MentorFirstName" + i);
                mentor.setLastName("MentorLastName" + i);
                provider.insert(SQLContract.MentorsEntry.TABLE_NAME, mentor);
            }
            List<AcademicGroup> groups = provider.query(SQLContract.AcademicGroupEntry.TABLE_NAME,null,null,null,null);
            List<Mentor> mentors = provider.query(SQLContract.MentorsEntry.TABLE_NAME,null,null,null,null);
            List<Integer> index = new ArrayList<>();
            for (Mentor mentor : mentors) {
                index.add(mentor.getMentorId());
            }
            for (int i = 0; i < groups.size(); i++) {
                AcademicGroup g = groups.get(i);
                g.setMentorId(index.get(i));
                provider.update(SQLContract.AcademicGroupEntry.TABLE_NAME, g);
            }
            List<Student> students = new ArrayList<>();
            for (int i = 0; i < 800; i++) {
                Student student = new Student();
                student.setFirstName("StudentFirstName" + i);
                student.setLastName("StudentLastName" + i);
                if (i < 400) {
                    student.setDateOfBirth(DateTime.parse("2001-11-05"));
                } else {
                    student.setDateOfBirth(DateTime.parse("2000-01-14"));
                }
                student.setTestBookNumber(10000 + i);
                int g = random.nextInt(25);
                while (g == 0) {
                    g = random.nextInt(25);
                }
                student.setGroupId(g);
                students.add(student);
            }
            int count = provider.bulkInsert(SQLContract.StudentsEntry.TABLE_NAME, students);
            System.out.println("bulk inserted "+count+ " records!");
            UserAccount userAccount = new UserAccount();
            userAccount.setUserName("admin");
            userAccount.setPassword("1234");
            provider.insert(SQLContract.UsersEntry.TABLE_NAME, userAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
