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
    // insert 800 students

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

    public static void populateData(SQLDBProvider provider) {
        Random random = new Random();
        try {
            provider.runSql("SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;");
            provider.runSql("SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;");
            provider.runSql("SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';");
            for (int i = 0; i < 25; i++) {
                AcademicGroup group = new AcademicGroup();
                group.setTitle(GROUPS[random.nextInt(10)]);
                provider.insertAcademicGroup(group);
            }
            for (int i = 0; i < 25; i++) {
                Mentor mentor = new Mentor();
                if (i % 2 == 0) {
                    mentor.setFirstName(FEMALE_FIRST_NAME[random.nextInt(10)]);
                    mentor.setLastName(FEMALE_LAST_NAME[random.nextInt(10)]);
                } else {
                    mentor.setFirstName(MALE_FIRST_NAME[random.nextInt(10)]);
                    mentor.setLastName(MALE_LAST_NAME[random.nextInt(10)]);
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
            for (int i = 0; i < 2300; i++) {
                Student student = new Student();
                if (i % 2 == 0) {
                    student.setFirstName(FEMALE_FIRST_NAME[random.nextInt(10)]);
                    student.setLastName(FEMALE_LAST_NAME[random.nextInt(10)]);
                } else {
                    student.setFirstName(MALE_FIRST_NAME[random.nextInt(10)]);
                    student.setLastName(MALE_LAST_NAME[random.nextInt(10)]);
                }
                student.setDateOfBirth(DateTime.parse(BIRTH_DAYS[random.nextInt(10)]));
                student.setTestBookNumber(100000 + i);
                int g = random.nextInt(25);
                while (g == 0) {
                    g = random.nextInt(25);
                }
                student.setGroupId(g);
                students.add(student);
            }
            int count = provider.bulkInsertStudents(students);
            System.out.println("bulk inserted "+count+ " records!");
            UserAccount userAccount = new UserAccount();
            userAccount.setUserName("admin");
            userAccount.setPassword("1234");
            provider.insertUserAccount(userAccount);
            provider.runSql("SET SQL_MODE=@OLD_SQL_MODE;");
            provider.runSql("SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;");
            provider.runSql("SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
