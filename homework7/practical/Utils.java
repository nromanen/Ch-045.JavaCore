package homework7.practical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by roma on 23.10.2016.
 */
public class Utils {
    //return arrays names
    public static String[] arrayNames(String names) {
        String[] arrayName = null;
        if (!names.isEmpty() & isValidUserSNP(names)) {
            arrayName = names.split(" ", 3);
        }
        return arrayName;
    }
    public static boolean isContains(String var1, String var2){
        if(var2.contains(var1)){
            return true;
        }
        return false;
    }
    //check the validity of the name, surname and patronymic
    public static boolean isValidUserSNP(String userName){
        String pattern = "[A-Z]{1}[a-z]{2,15}\\s[A-Z]{1}[a-z]{2,15}\\s[A-Z]{1}[a-z]{2,15}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(userName);
        if(m.matches()){
            return true;
        };
        return false;
    }
    //return name
    public static String printName(String[] arrayNames){
        StringBuilder builder = new StringBuilder();
        builder.append("name: ").append(arrayNames[1]);
        return builder.toString();
    }
    //return surnames and initials
    public static String printSurnameInitials(String[] arrayName){
        StringBuilder surnameNP = new StringBuilder();
        if(arrayName.length!=0){
            surnameNP.append("surname and initials:\n").append(arrayName[0]).append(" ").
                    append(arrayName[1].charAt(0)).append(".").
                    append(arrayName[2].charAt(0)).append(".");
            return surnameNP.toString();
        } else return "not true surname, name and patronymic";
    }
    // name, middle name and last name
    public static String printNameMidLast(String[] arrayNames){
        StringBuilder nameML = new StringBuilder();
        if(arrayNames.length!=0){
            nameML.append("name, middle name and last name:\n").append(arrayNames[1]).append(" ").
                    append(arrayNames[0]).append(" ").append(arrayNames[2]);
            return nameML.toString();
        } else return "not true surname, name and patronymic";
    }
}
