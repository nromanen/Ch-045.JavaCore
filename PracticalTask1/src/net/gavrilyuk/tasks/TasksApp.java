package net.gavrilyuk.tasks;

import java.util.Scanner;

/**
 * In method main() write code for solving next tasks:
 * Define integer variables a and b. Read values a and b from Console and calculate: a + b, a - b, a * b, a / b.
 * Output obtained results.
 * Output question “How are you?“. Define string variable answer. Read the value answer and output: “You are (answer)".

 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class TasksApp {




    public static void main(String[] args) {
        int a;
        int b;
        String answer;
        Scanner scanner = new Scanner(System.in);
        a= TasksUtil.readInt(scanner);
        b= TasksUtil.readInt(scanner);
        System.out.println("a+b="+(a+b));
        System.out.println("a-b="+(a-b));
        System.out.println("a*b="+(a*b));
        System.out.println("a/b="+(a/b));
        System.out.println("How are you?");
        answer = String.valueOf(TasksUtil.readInt(scanner));
        System.out.println("You are "+answer);
        scanner.close();

    }
}
