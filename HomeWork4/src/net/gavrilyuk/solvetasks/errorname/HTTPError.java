package net.gavrilyuk.solvetasks.errorname;

/**
 *
 * Created by Igor Gavrilyuk on 07.10.2016.
 */
public enum HTTPError {

    SC_BAD_REQUEST(400,"Bad Request"),
    SC_UNAUTHORIZED(401,"Unauthorized"),
    SC_PAYMENT_REQUIRED(402,"Payment Required"),
    SC_FORBIDDEN(403,"Forbidden"),
    SC_NOT_FOUND(404,"Not Found"),
    SC_METHOD_NOT_ALLOWED(405,"Method Not Allowed"),
    SC_NOT_ACCEPTABLE(406,"Not Acceptable"),
    SC_PROXY_AUTHENTICATION_REQUIRED(407,"Proxy Authentication Required"),
    SC_REQUEST_TIMEOUT(408,"Request Timeout"),
    SC_CONFLICT(409,"Conflict"),
    SC_GONE(410,"Gone");

    private int mCode;
    private String mName;



    HTTPError(int code, String name) {
        mCode = code;
        mName = name;
    }

    public int getCode() {
        return mCode;
    }

    public String getName() {
        return mName;
    }





}
