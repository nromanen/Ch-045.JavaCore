package net.students.dao;

import net.students.dao.SQLContract.StudentsEntry;
import net.students.model.AcademicGroup;
import net.students.model.Mentor;
import net.students.model.Student;
import net.students.model.UserAccount;
import net.students.util.AppUtils;
import org.joda.time.DateTime;

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
    public static String buildSqlQuery(String table, String[] projection, String selection, String[] selectionArgs,
                                       String sortOrder, String offset, String numOfRecords) {
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
            sql.append(" ORDER BY").append(" ").append(sortOrder);
        }
        if (offset != null && numOfRecords != null) {
            sql.append(" LIMIT ").append(offset).append(",").append(numOfRecords);
        }
        return sql.toString();
    }

    //build sql query for calculate count records
    public static String buildCountSQLQuery(String table , String selection, String[] selectionArgs) {
        StringBuilder exprBuilder  = new StringBuilder();
        exprBuilder.append("SELECT COUNT(*) ");
        if (selection == null  ) {
            exprBuilder.append("FROM ").append(table);
        } else {
            if (selectionArgs != null && selectionArgs.length > 0) {
                exprBuilder.append("FROM ").append(table).append(" WHERE ");
                for (String s : selectionArgs) {
                    selection= selection.replaceFirst("\\?",s);
                }
                exprBuilder.append(selection).append(" ");
            } else exprBuilder.append("FROM ").append(table);
        }
        return exprBuilder.toString();
    }



    //fill filter query data
    public static String  buildSelectionFormFilter(String firstName, String lastName, String testBookNum,String  groupId ) {
        String selection ;
        Map<String,String> selections = new LinkedHashMap<>();
        if (!AppUtils.isEmpty(testBookNum)) {
            selections.put(StudentsEntry.COL_BOOK_NUM, testBookNum);
        }
        if (!AppUtils.isEmpty(firstName) ) {
            selections.put(StudentsEntry.COL_FIRST_NAME,"'" + firstName + "%'");
        }
        if (!AppUtils.isEmpty(lastName) ) {
            selections.put(StudentsEntry.COL_LAST_NAME,"'" + lastName + "%'");
        }
        if (!AppUtils.isEmpty(groupId)) {
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
        return selection;
    }

    public static String[] buildSelectionArgsFilter(String firstName, String lastName, String testBookNum,String  groupId) {
        String[] selectionArgs;
        Map<String,String> selections = new LinkedHashMap<>();
        if (!AppUtils.isEmpty(testBookNum)) {
            selections.put(SQLContract.StudentsEntry.COL_BOOK_NUM, testBookNum);
        }
        if (!AppUtils.isEmpty(firstName) ) {
            selections.put(SQLContract.StudentsEntry.COL_FIRST_NAME,"'" + firstName + "%'");
        }
        if (!AppUtils.isEmpty(lastName) ) {
            selections.put(SQLContract.StudentsEntry.COL_LAST_NAME,"'" + lastName + "%'");
        }
        if (!AppUtils.isEmpty(groupId)) {
            selections.put(SQLContract.StudentsEntry.COL_GROUP_ID, groupId);
        }
        selectionArgs = selections.values().toArray(new String[selections.size()]);
        return selectionArgs;
    }


    // For test database: populate data
    // insert 25 academic groups
    // insert 25 mentors
    // insert 2300 students
    private static final int GROUP_COUNT = 25;
    private static final int MENTOR_COUNT = 25;
    private static final int STUDENT_COUNT = 1300;

    private static final String[]
            FEMALE_FIRST_NAME = new String[]{"Ірина", "Надія", "Аліна", "Ліна", "Марія",
            "Оксана", "Людмила", "Світлана", "Катерина", "Олеся"};
    private static final String[] MALE_FIRST_NAME = new String[]{"Микола", "Іван", "Артем", "Дмитро", "Ігор",
            "Петро", "Степан", "Ярослав", "Сергій", "Святослав"};
    private static final String[] FEMALE_LAST_NAME = new String[]{"Приходько", "Яремчук", "Невмержицька", "Левківська", "Петренко",
            "Кононова", "Бойко", "Поліщук", "Неймирович-Данченко", "Спілберг"};
    private static final String[] MALE_LAST_NAME = new String[]{"Ковальчук", "Назарчук", "Лівшиц", "Матвійчук", "Козлов",
            "Перекотиполе", "Перильман", "Диконокадзе", "Абрамавичус", "Малисов"};
    private static final String[] BIRTH_DAYS = new String[]{"2001-11-05", "2000-02-05", "2001-07-13", "2002-10-25", "2002-04-07",
            "2003-09-09", "2001-08-17", "2001-12-23", "2001-04-08", "2001-06-27"};
    private static final String[] GROUPS = new String[]{"фізика та математика", "тупо математика", "математика та інформатика", "педагогіка", "філологія",
            "історія та провознавство", "філософія", "програмування", "географія і хімія", "астрономія"};

    public static int populateData(SQLDBProvider provider) {
        int count = 0;
        Random random = new Random();
        try {
            provider.runSQL("SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;");
            provider.runSQL("SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;");
            provider.runSQL("SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';");
            for (int i = 0; i < GROUP_COUNT; i++) {
                AcademicGroup group = new AcademicGroup();
                group.setTitle(GROUPS[random.nextInt(GROUPS.length)]);
                provider.insertAcademicGroup(group);
            }
            for (int i = 0; i < MENTOR_COUNT; i++) {
                Mentor mentor = new Mentor();
                if (i % 2 == 0) {
                    mentor.setFirstName(FEMALE_FIRST_NAME[random.nextInt(FEMALE_FIRST_NAME.length)]);
                    mentor.setLastName(FEMALE_LAST_NAME[random.nextInt(FEMALE_LAST_NAME.length)]);
                } else {
                    mentor.setFirstName(MALE_FIRST_NAME[random.nextInt(MALE_FIRST_NAME.length)]);
                    mentor.setLastName(MALE_LAST_NAME[random.nextInt(MALE_LAST_NAME.length)]);
                }
                provider.insertMentor(mentor);
            }
            List<AcademicGroup> groups = provider.queryAcademicGroups(null, null, null, null);
            List<Mentor> mentors = provider.queryMentors(null, null, null, null);
            List<Integer> index = new ArrayList<>();
            for (Mentor mentor : mentors) {
                index.add(mentor.getMentorId());
            }
            for (int i = 0; i < groups.size(); i++) {
                AcademicGroup g = groups.get(i);
                g.setMentorId(index.get(i));
                provider.updateAcademicGroup(g);
            }
            List<Student> students = new ArrayList<>();
            for (int i = 0; i < STUDENT_COUNT; i++) {
                Student student = new Student();
                if (i % 2 == 0) {
                    student.setFirstName(FEMALE_FIRST_NAME[random.nextInt(FEMALE_FIRST_NAME.length)]);
                    student.setLastName(FEMALE_LAST_NAME[random.nextInt(FEMALE_LAST_NAME.length)]);
                } else {
                    student.setFirstName(MALE_FIRST_NAME[random.nextInt(MALE_FIRST_NAME.length)]);
                    student.setLastName(MALE_LAST_NAME[random.nextInt(MALE_LAST_NAME.length)]);
                }
                student.setDateOfBirth(DateTime.parse(BIRTH_DAYS[random.nextInt(BIRTH_DAYS.length)]));
                student.setTestBookNumber(100000 + i);
                int g = random.nextInt(GROUP_COUNT);
                while (g == 0) {
                    g = random.nextInt(GROUP_COUNT);
                }
                student.setGroupId(g);
                students.add(student);
            }
            count = provider.bulkInsertStudents(students);
            UserAccount userAccount = new UserAccount();
            userAccount.setUserName("admin");
            userAccount.setPassword("1234");
            provider.insertUserAccount(userAccount);
            provider.runSQL("SET SQL_MODE=@OLD_SQL_MODE;");
            provider.runSQL("SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;");
            provider.runSQL("SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;");
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            return count;
        }
    }

}
