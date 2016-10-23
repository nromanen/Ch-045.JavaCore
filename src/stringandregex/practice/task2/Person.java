package stringandregex.practice.task2;

import util.Scan;
import static util.Print.println;


public class Person {

    private String name = "";
    private String surname = "";
    private String patronymic = "";

    public Person(String fullName) {

        fullName = prepare(fullName);
        String[] strArray = fullName.split(" ");
        if(strArray.length != 0){
            this.surname = strArray[0];
            try {
                this.name = strArray[1];
            } catch (ArrayIndexOutOfBoundsException e){
                println("No name.");
            }
            try {
                this.patronymic = strArray[2];
            } catch (ArrayIndexOutOfBoundsException e){
                println("No patronymic.");
            }
        } else {
            println("Incorrect data. Person created with empty parameters. Use Seters to add info about person.");
        }
    }

    // seters and geters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFullName(){
        return this.surname + this.name + this.patronymic;
    }

    public String getShortName(){
        return this.surname + " " + name.charAt(0) +"." + patronymic.charAt(0) + ".";
    }

    // Method prepare full name entered by user to saving in the class variables
    private String prepare(String fullName) {
        // convert fullname to lower case
        fullName = fullName.toLowerCase();
        // replace whitespace characters to " "
        fullName = fullName.replaceAll("[\\s]{2,}", " ");
        // delete whitespace characters inf the begin and in the end of full name
        fullName.trim();

        // String to char array
        char[] cArr = fullName.toCharArray();

        // Make the first letter and the letters after whitespace in upper case
        for (int i = 0; i < cArr.length-1; i++){
            if(i == 0){
                    cArr[i] -= 32;
            }
            if (cArr[i] == 32){
                    cArr[i+1] -= 32;
            }
        }

        // Make string from char array using StringBuilder
        StringBuilder sb = new StringBuilder("");

        for (char c : cArr) {
            sb.append(c);
        }
        fullName = sb.toString();

        // return correct fullname
        return  fullName;

    }

    // Method check the variables name, surname and patronymic are empty.
    // If they are empty asks to enter this variables
    public boolean checkInit(){
        if (this.getName().isEmpty()){
            println("Enter name of person:");
            this.setName(prepare(Scan.getString(3)));
        }

        if (this.getSurname().isEmpty()){
            println("Enter surname of person:");
            this.setSurname(prepare(Scan.getString(3)));
        }

        if (this.getPatronymic().isEmpty()){
            println("Enter patronymic of person:");
            this.setPatronymic(prepare(Scan.getString(3)));
        }

        return true;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + patronymic;
    }
}
