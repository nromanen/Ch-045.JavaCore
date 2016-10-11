package lesson3.days;

/**
 * Created by Admin on 10.10.16.
 */
public enum DaysEng {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public static DaysEng getDay(int n){

        switch (n){
            case 1:
                return DaysEng.MONDAY;
              case 2:
                return DaysEng.TUESDAY;
              case 3:
                return DaysEng.WEDNESDAY;
              case 4:
                return DaysEng.THURSDAY;
              case 5:
                return DaysEng.FRIDAY;
              case 6:
                return DaysEng.SATURDAY;
              case 7:
                return DaysEng.SUNDAY;
            default:
                return null;
        }
    }
}
