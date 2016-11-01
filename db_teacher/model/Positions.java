package db_teacher.model;

/**
 * Created by roma on 24.10.2016.
 */
//'PHYSICS','MATH','GEOGRAPHY','CHEMISTRY','UKRAINIAN','ENGLISH','HISTORY','BIOLOGY'
public enum Positions {
    PHYSICS("physics"),
    MATH("math"),
    GEOGRAPHY("geography"),
    CHEMISTRY("chemistry"),
    UKRAINIAN("ukrainian language"),
    ENGLISH("english language"),
    HISTORY("history"),
    BIOLOGY("biology");

    public String title;
    
    Positions(){}
    Positions(String title){
        this.title = title;
    }
}
