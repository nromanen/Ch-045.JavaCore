package lesson3.country;

import util.Scan;

import static util.Print.print;
import static util.Print.println;

/**
 * Created by Admin on 10.10.16.
 */
public class Main {

    public static void main(String... args){

        String name;
        boolean isCountry = false;
        print("Enter name of the country: ");
        name = Scan.getString(4);
        for (Country country: Countries.getCountries()) {
            if (country.getName().equals(name)) {
                println(name + " is on " + country.getContrinent());
                isCountry = true;
                break;
            }
        }
        if (!isCountry){
            println("There is not same country is the country list. Use Countries.add(Country country) method to add new countries in the list");
        }

        Scan.close();
    }
}
