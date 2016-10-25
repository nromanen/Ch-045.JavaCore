package net.gavrilyuk.task2;

import java.util.Scanner;

/**
 *
 * Created by Igor Gavryliuk on 25.10.2016.
 */
public class RangeChecker {

    private Scanner scanner;
    private int start;
    private int end;

    public RangeChecker(Scanner scanner, int start, int end) throws InvalidRangeException {
        if (end < start)  throw new InvalidRangeException("End of the range is less than the beginning of the range");
        this.scanner = scanner;
        this.start = start;
        this.end = end;
    }

    public RangeChecker(Scanner scanner) {
        this(scanner,1,100);
    }

    public RangeChecker() {
        this(new Scanner(System.in), 1, 100); //default read from console

    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        if (start > end)
            throw new InvalidRangeException("Beginning of the range longer end of the range");
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) throws InvalidRangeException {
        if (end < start)
            throw new InvalidRangeException("End of the range is less than the beginning of the range");
        this.end = end;
    }

    public int readNumber() {
        return readNumber(start, end);
    }

    // returns int, if it is in the range [start...end]
    public  int readNumber( int start, int end) throws InvalidRangeException {
        String line = null;
        int result = 0;
        if (end < start)
            throw new InvalidRangeException("End of the range is less than the beginning of the range");
        System.out.print("Enter value:");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Integer.parseInt(line);
                if (result < start || result> end) {
                    throw new OutOfRangeException("Value " + result+" out of range:["+start+","+end+"]");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid  value:" + line);
                System.out.print("Enter value:");
            } catch (OutOfRangeException e) {
                System.out.println(e.getMessage());
                System.out.print("Enter value:");
            }
        }
        return result;
    }

    public void closeScanner() {
        if (scanner!=null) scanner.close();
    }
}
