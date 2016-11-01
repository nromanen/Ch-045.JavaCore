package students.model;

import students.logic.SQLContract.AcademicGroupEntry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class AcademicGroup
{
    private int groupId;
    private String title;
    private int mentor;
    private Collection students;

    public AcademicGroup() {
    }

    public AcademicGroup(ResultSet rs) throws SQLException {
        setGroupId(rs.getInt(AcademicGroupEntry.ID));
        setMentor(rs.getInt(AcademicGroupEntry.COL_MENTOR_ID));
        setTitle(rs.getString(AcademicGroupEntry.COL_TITLE));
    }

    public int getMentor() {
        return mentor;
    }

    public void setMentor(int mentor) {
        this.mentor = mentor;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return title;
    }

    public Collection getStudents() {
        return students;
    }

    public void setStudents(Collection students) {
        this.students = students;
    }
}
