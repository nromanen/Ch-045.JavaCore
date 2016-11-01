package students.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mentor Class
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class Mentor extends Person {

    public Mentor() {
        super();
    }

    public Mentor(ResultSet rs) throws SQLException {
        super(rs);
    }

}
