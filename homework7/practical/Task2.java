package homework7.practical;

/**
 * Created by roma on 21.10.2016.
 * Enter surname, name and patronymic on the console as a variable of type String.
 * Output on the console:
        surnames and initials
        name
        name, middle name and last name

 */
public class Task2 {
    public static void main(String[] args){

        String names = "Penteleychuk Roman Georg";
        String[] arrayNames = Utils.arrayNames(names);

        System.out.println(Utils.printName(arrayNames));

        //print surname and initials;
        System.out.println(Utils.printSurnameInitials(arrayNames));

        // name, middle name and last name
        System.out.println(Utils.printNameMidLast(arrayNames));

    }


}
