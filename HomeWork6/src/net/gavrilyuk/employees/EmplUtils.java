package net.gavrilyuk.employees;

import java.util.*;

/**
 * Employee Util Class from read, sort , filtering data.
 * Created by Igor Gavrilyuk on 12.10.2016.
 */
public class EmplUtils {

    // returns the department number entered from the console
    public static int readDepNumber(Scanner scanner) {
        String line = null;
        int result = 0;
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Integer.parseInt(line);
                if (result < 0) {
                    throw new NumberFormatException("Invalid value:" + result);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("Please select department:");
            }
        }
        return result;
    }


    //return list filtered by department or empty list
    public static List<PaidWorker> filterByDep(int department, List<PaidWorker> paidWorkers) {
        List<PaidWorker> result= new ArrayList<>();
        if (paidWorkers != null && paidWorkers.size() > 0) {
            for (PaidWorker paidWorker : paidWorkers) {
                if (paidWorker.getDepartment().ordinal() == department) {
                    result.add(paidWorker);
                }
            }
        }
        return result;
    }

    //return  sorted list on the average monthly wage
    public static List<PaidWorker> orderBySalary(List<PaidWorker> employees ) {
        if (employees != null ) {
            List<PaidWorker> result = new ArrayList<>(employees);
            Collections.sort(result, new Comparator<PaidWorker>() {
                @Override
                public int compare(PaidWorker c1, PaidWorker c2) {
                    if (c1.calculatePay() > c2.calculatePay())
                        return -1;
                    if (c1.calculatePay() == c2.calculatePay())
                        return 0;
                    return 1;
                }
            });
          return result;  //return sorted list
        } else {
            return new ArrayList<>();//return empty list
        }
    }

    //print menu dep number - dep name
    public static String showDepChoicer() {
        StringBuilder builder = new StringBuilder();
        for (Department department : Department.values()) {
            builder.append(department.toString()).append("\n");
        }
        builder.append("Please select department:");
        return builder.toString();
    }
}
