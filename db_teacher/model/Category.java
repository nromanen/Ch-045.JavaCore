package db_teacher.model;

/**
 * Created by roma on 25.10.2016.
 */

//'SPECIALIST_H_CAT','SPECIALIST_1_CAT','SPECIALIST_2_CAT','SPECIALIST'
public enum Category {
    SPECIALIST_H_CAT("Specialist highest category", 25),
    SPECIALIST_1_CAT("Specialist Category 1", 20),
    SPECIALIST_2_CAT("Specialist Category 2", 15),
    SPECIALIST("Specialist",10);

    public String title;
    public int surcharge;

    Category(String title, int surcharge) {
        this.title = title;
        this.surcharge = surcharge;
    }

    public int getSurcharge() {
        return surcharge;
    }

    public String getTitle() {
        return title;
    }
}
