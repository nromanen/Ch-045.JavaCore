package students.logic;

/**
 * Defines table and column names for the students database.
 * Created by Igor Gavryliuk on 26.10.2016.
 */
public class SQLContract {


    /* Inner class that defines the table contents of the student table */
    public static final class StudentsEntry implements BaseColumns {
        // Table name
        public static final String TABLE_NAME = "student";
        public static final String COL_FIRST_NAME = "first_name";
        public static final String COL_LAST_NAME = "last_name";
        public static final String COL_BOOK_NUM = "book_number";
        public static final String COL_BIRTH_DAY = "birth_day";
        public static final String COL_GROUP_ID = "group_id";
    }

    /* Inner class that defines the table contents of the mentor table */
    public static final class MentorsEntry implements BaseColumns {

        public static final String TABLE_NAME = "mentor";
        public static final String COL_FIRST_NAME = "first_name";
        public static final String COL_LAST_NAME = "last_name";
        public static final String COL_GROUP_ID = "group_id";

    }

    /* Inner class that defines the table contents of the Academic AcademicGroup table */
    public static final class AcademicGroupEntry implements BaseColumns {

        public static final String TABLE_NAME = "academic_group";
        public static final String COL_TITLE = "title";
        public static final String COL_MENTOR_ID = "mentor_id";

    }
}
