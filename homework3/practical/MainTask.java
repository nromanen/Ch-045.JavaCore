package homework3.practical;

/**
  Created by roma on 05.10.2016.
 1) Enter three numbers.
    Find out how many of them are odd.
 2) Enter the number of the day of the week.
    Display the name in three languages.
 3) Enter the name of the country. Print the name of the continent.
    (Declare enum with names of continents)

 */

public class MainTask {

    public static void main(String[] args){

        //Enter three numbers. Find out how many of them are odd.
        int a = 68;
        int b = 2;
        int c = 4;
        int countOdd = 0;

        if (a%2 == 0) countOdd++;
        if (b%2 == 0) countOdd++;
        if (c%2 == 0) countOdd++;

        System.out.println("Odd numbers = "+countOdd);

        int [] mass = {34,43,7,45,678,4,3,4,56,7};
        int oddSum = 0;
        MainTask task = new MainTask();

        //Find odd
        for (int i=0; i<mass.length; i++ ){
            if(mass[i]%2 == 0){ oddSum++;}
        }
        System.out.println("Odd number = "+oddSum);

        //Enter the number of the day of the week. Display the name in three languages.

        int numberDay = 1;
        String day = "";
        switch (numberDay){
            case 1: day = "nподеділок monday lundi ";
                break;
            case 2: day = " вівторок tuesday mardi ";
                break;
            case 3: day = "середа wednesday mercredi";
                break;
            case 4: day = "четвер thursday vendredi";
                break;
            case 5: day = "п'ятниця friday jeudi";
                break;
            case 6: day = "субота saturday samedi";
                break;
            case 7: day = "неділя sunday dimanche";
                break;
            default: day = "not a day number!";
        }
        System.out.print("Day №" + numberDay + ": ");
        System.out.println(day);

        // Enter the name of the country. Print the name of the continent.
        // (Declare enum with names of continents)
        String country = "Ukraine";
        String continent = "";

        switch (country){
            case "Canada":case "USA":case "Mexico": continent = String.valueOf(Continents.North_America);
                break;
            case "Ukraine":case "Poland":case "France": continent = String.valueOf(Continents.Eurasia);
                break;
            case "Brazil":case "Peru":case "Bolivia": continent = String.valueOf(Continents.South_America);
                break;
            case "Nigeria":case "Egypt":case "Zambia": continent = String.valueOf(Continents.Africa);
                break;
            case "Australia": continent = String.valueOf(Continents.Antarctica);
                break;
            case "": continent = String.valueOf(Continents.Antarctica);
            default: System.out.print("A country not listed!");
                break;
        }
        System.out.println("Country: "+ country);
        System.out.println("Continent: "+continent);
    }
}
