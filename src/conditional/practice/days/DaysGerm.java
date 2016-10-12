package conditional.practice.days;

public enum DaysGerm {
    MONTAG, DIENSTAG, MITTWOCH, DONNERSTAG, FREITAG, SAMSTAG,  SONNTAG;

    // Method return name of the week day by it number
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
