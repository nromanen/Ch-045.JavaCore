package homework3.homework;

/**
 * Created by roma on 11.10.2016.
 *
 * Solve the next tasks:
        * read 3 float numbers and check: are they all belong to the range [-5,5];
        * read 3 integer numbers and write max and min of them;
        * read number of HTTP Error (400, 401,402, ...) and write the name of this error (Declare enum HTTPError)
 */
public class MainTask {
    private enum HTTPError{
        BAD_REQUEST,                    //400
        UNAUTHORIZED,                   //401
        PAYMENT_REQUEST,                //402
        FORBIDDEN,                      //403
        }

    public static void main(String[] args){

        //read 3 float numbers and check: are they all belong to the range [-5,5];
        double a =  -2.3;
        double b = 5;
        double c = 5;

        if ( (a<=5)&(a>=-5) & (b<=5)&(b>=-5) & (c<=5)&(c>=-5) ){
            System.out.println("They all belong to the range [-5,5]");
        } else System.out.println("false");

        //read 3 integer numbers and write max and min of them;
        int x = 12;
        int y = -45;
        int z = 67;

        int max = Math.max(x,y);
        if( max>y ){
            max = Math.max(x,z);
        }
        else{
            max = Math.max(y,z);
        }
        System.out.println("The max of three is: " + max);

        //read number of HTTP Error (400, 401,402, ...) and write the name of this error (Declare enum HTTPError)
        int httpError = 400;
        System.out.println("Enter HTTP Error "+httpError);
        switch (httpError) {
            case 400:
                System.out.println("This error: " + HTTPError.BAD_REQUEST);
                break;
            case 401:
                System.out.println("This error: " + HTTPError.UNAUTHORIZED);
                break;
            case 402:
                System.out.println("This error: " + HTTPError.PAYMENT_REQUEST);
                break;
            case 403:
                System.out.println("This error: " + HTTPError.FORBIDDEN);
                break;
            default:
                System.out.println("This code not found");
        }
    }

}
