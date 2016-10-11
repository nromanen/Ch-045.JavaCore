package lesson3.httperrors;

/**
 * Created by Admin on 11.10.16.
 */
public enum HTTPErrors {
    BAD_REQUEST, UNAUTHORIZED, PAYMENT_REQUIRED, FORBIDDEN, NOT_FOUND, METHOD_NOT_ALLOWED, NOT_ACCEPTABLE,
    PROXY_AUTHENTICATION_REQUIRED, REQUEST_TIMEOUT, CONFLICT, GONE, LENGTH_REQUIRED, PRECONDITION_FAILED,
    PAYLOAD_TOO_LARGE, URI_TOO_LONG, UNSUPPORTED_MEDIA_TYPE, RANGE_NOT_SATISFIABLE, EXPECTATION_FAILED,
    I_AM_A_TEAPOT, MISDIRECTED_REQUEST, UNPROCESSABLE_ENTITY, LOCKED, FAILED_DEPENDENCY, UPGRADE_REQUIRED,
    PRECONDITION_REQUIRED, TOO_MANY_REQUESTS, REQUEST_HEADER_FIELDS_TOO_LARGE, UNAVAILABLE_FOR_LEGAL_REASONS;

    public static HTTPErrors getHTTPErrors (int code){
        switch (code){
            case 400:
                return HTTPErrors.BAD_REQUEST;
            case 401:
                return HTTPErrors.UNAUTHORIZED;
            case 402:
                return HTTPErrors.PAYMENT_REQUIRED;
            case 403:
                return HTTPErrors.FORBIDDEN;
            case 404:
                return HTTPErrors.NOT_FOUND;
            case 405:
                return HTTPErrors.METHOD_NOT_ALLOWED;
            case 406:
                return HTTPErrors.NOT_ACCEPTABLE;
            case 407:
                return HTTPErrors.PROXY_AUTHENTICATION_REQUIRED;
            case 408:
                return HTTPErrors.REQUEST_TIMEOUT;
            case 409:
                return HTTPErrors.CONFLICT;
            case 410:
                return HTTPErrors.GONE;
            case 411:
                return HTTPErrors.LENGTH_REQUIRED;
            case 412:
                return HTTPErrors.PRECONDITION_FAILED;
            case 413:
                return HTTPErrors.PAYLOAD_TOO_LARGE;
            case 414:
                return HTTPErrors.URI_TOO_LONG;
            case 415:
                return HTTPErrors.UNSUPPORTED_MEDIA_TYPE;
            case 416:
                return HTTPErrors.RANGE_NOT_SATISFIABLE;
            case 417:
                return HTTPErrors.EXPECTATION_FAILED;
            case 418:
                return HTTPErrors.I_AM_A_TEAPOT;
            case 421:
                return HTTPErrors.MISDIRECTED_REQUEST;
            case 422:
                return HTTPErrors.UNPROCESSABLE_ENTITY;
            case 423:
                return HTTPErrors.LOCKED;
            case 424:
                return HTTPErrors.FAILED_DEPENDENCY;
            case 426:
                return HTTPErrors.UPGRADE_REQUIRED;
            case 428:
                return HTTPErrors.PRECONDITION_REQUIRED;
            case 429:
                return HTTPErrors.TOO_MANY_REQUESTS;
            case 431:
                return HTTPErrors.REQUEST_HEADER_FIELDS_TOO_LARGE;
            case 451:
                return HTTPErrors.UNAVAILABLE_FOR_LEGAL_REASONS;
            default:
                return null;
        }
    }
}
