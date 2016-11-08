package net.students.util;

import net.students.model.UserAccount;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * Created by Igor Gavryliuk on 04.11.2016.
 */
public class AppUtils {

    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

    // Get the user information stored in the session.
    public static UserAccount getLoginedUser(HttpSession session) {
        return (UserAccount) session.getAttribute("loginedUser");
    }
    // Store user info in Session.
    public static void storeLoginedUser(HttpSession session, UserAccount loginedUser) {
        // On the JSP can access ${loginedUser}
        session.setAttribute("loginedUser", loginedUser);
    }

    // Store info in Cookie
    public static void storeUserCookie(HttpServletResponse response, UserAccount user) {
        System.out.println("Store user cookie");
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUserName());

        // 1 day (Convert to seconds)
        cookieUserName.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUserName);
    }

    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }


    // Delete cookie.
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
        // 0 seconds (Expires immediately)
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }

    /**
     * Returns true if the string is null or 0-length.
     */
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }
}
