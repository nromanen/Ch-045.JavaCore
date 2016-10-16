package HttpError;

/**
 * Created by evil on 11.10.16.
 */

public class HTTPStatus {
    private int statusNumber;
    private EnumOfHTTPStatus statusName;

    private enum EnumOfHTTPStatus {
        BAD_GETAWAY, UNAUTHORIZED, PAYMENT_REQUIRED, FORBIDDEN, NOT_FOUND
    }
    public HTTPStatus(){
    }
    public void findHttpStatus(int number){
        switch (number){
            case 400:
                statusName = EnumOfHTTPStatus.BAD_GETAWAY;
                this.statusNumber = number;
                break;
            case 401:
                statusName = EnumOfHTTPStatus.UNAUTHORIZED;
                this.statusNumber = number;
                break;
            case 402:
                statusName = EnumOfHTTPStatus.PAYMENT_REQUIRED;
                this.statusNumber = number;
                break;
            case 403:
                statusName = EnumOfHTTPStatus.FORBIDDEN;
                this.statusNumber = number;
                break;
            case 404:
                statusName = EnumOfHTTPStatus.NOT_FOUND;
                this.statusNumber = number;
                break;
            default:
                System.out.println("Don't found this status");
        }
    }

    @Override
    public String toString() {
        return "HTTPStatus{" +
                "statusNumber='" + statusNumber + '\'' +
                ", statusName=" + statusName +
                '}';
    }
}
