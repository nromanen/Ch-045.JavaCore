package homework1.user;

import homework1.inputmethod.Input;

/**
 * Created by roma on 28.09.2016.
 */
public class MainUser {

    public static void main(String[] args){
        Users users = new Users();

        users.setName(Input.inputName("What is your name!"));
        String name = users.getName();
        users.setAdr(Input.inputName("Where are you live, " + name));
        users.setAge(Input.inputInt("How old are you, " + name));

        MainUser.output(users.getName(), users.getAge(), users.getAdr());
    }
    public static void output(String name, int age, String address){
        System.out.println("========================================");
        System.out.println("Your name: " + name);
        System.out.println("Your age: " + age);
        System.out.println("Your address: " + address);
    }
}
