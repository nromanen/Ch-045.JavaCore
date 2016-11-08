package net.students.filter;

import net.students.dao.SQLContract.UsersEntry;
import net.students.dao.SQLDBProvider;
import net.students.model.UserAccount;
import net.students.util.AppUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * Created by Igor Gavryliuk on 04.11.2016.
 */
@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter{

    private SQLDBProvider provider;

    public CookieFilter() {
        provider = new SQLDBProvider();
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        UserAccount userInSession = AppUtils.getLoginedUser(session);
        if (userInSession != null) {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;
        }
        // Flag check cookie
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        if (checked == null && provider != null) {
            String userName = AppUtils.getUserNameInCookie(req);
            try {
                List users = provider.query(UsersEntry.TABLE_NAME, null,
                        UsersEntry.COL_USER_NAME + " =? ", new String[]{"'"+userName+"'"}, null);
                if (users!=null && users.size()>0){
                    //UserAccount user = provider.findUser( userName);
                    UserAccount user = (UserAccount) users.get(0);
                    AppUtils.storeLoginedUser(session, user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // Mark checked.
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
        }
        chain.doFilter(request, response);
    }
}
