package conditional.practice.days;

public enum DaysRus {
    PONEDELNIK, VTORNIK, SREDA, CHETVERG, PIATNITSA, SUBOTA, VOSKRESENIE;

    // Method return name of the week day by it number
    public static DaysRus getDay(int n){
        switch (n){
            case 1:
                return DaysRus.PONEDELNIK;
            case 2:
                return DaysRus.VTORNIK;
            case 3:
                return DaysRus.SREDA;
            case 4:
                return DaysRus.CHETVERG;
            case 5:
                return DaysRus.PIATNITSA;
            case 6:
                return DaysRus.SUBOTA;
            case 7:
                return DaysRus.VOSKRESENIE;
            default:
                return null;

        }
    }
}
