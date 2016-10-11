package lesson3.days;

/**
 * Created by Admin on 10.10.16.
 */
public enum DaysGerm {
    MONTAG, DIENSTAG, MITTWOCH, DONNERSTAG, FREITAG, SAMSTAG,  SONNTAG;

    public static DaysGerm getDay(int n){

        switch (n){
            case 1:
                return DaysGerm.MONTAG;
            case 2:
                return DaysGerm.DIENSTAG;
            case 3:
                return DaysGerm.MITTWOCH;
            case 4:
                return DaysGerm.DONNERSTAG;
            case 5:
                return DaysGerm.FREITAG;
            case 6:
                return DaysGerm.SAMSTAG;
            case 7:
                return DaysGerm.SONNTAG;
            default:
                return null;
        }
    }
}
