/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.6
 * Generated at: 2016-11-08 01:35:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsps;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newEmployee_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/WEB-INF/tags/page/header.tag", Long.valueOf(1478566073859L));
    _jspx_dependants.put("/WEB-INF/tags/page/css.tag", Long.valueOf(1478408022906L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1478197958000L));
    _jspx_dependants.put("/WEB-INF/tags/page/js.tag", Long.valueOf(1478408022734L));
    _jspx_dependants.put("jar:file:/D:/ariezz/SoftServe_java/testservlet/web/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153374282000L));
    _jspx_dependants.put("/WEB-INF/tags/page/footer.tag", Long.valueOf(1478432062703L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Add new Employee</title>\r\n");
      out.write("    ");
      if (_jspx_meth_page_005fcss_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      if (_jspx_meth_page_005fheader_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <hr>\r\n");
      out.write("    <h2>Add new Employee</h2>\r\n");
      out.write("    <form method=\"post\" action=\"/employee?action=new\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group col-md-8\">\r\n");
      out.write("            <label for=\"firstName\">Firstname:</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" name=\"firstName\" placeholder=\"First Name\" id=\"firstName\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group col-md-8\">\r\n");
      out.write("            <label for=\"lastName\">Lastname:</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" name=\"lastName\" placeholder=\"Last Name\" id=\"lastName\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group col-md-8\">\r\n");
      out.write("            <label for=\"bDay\">B-day:</label>\r\n");
      out.write("            <input type=\"date\" class=\"form-control\" name=\"bDay\" placeholder=\"yyyy-mm-dd\" id=\"bDay\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group col-md-8\">\r\n");
      out.write("            <label for=\"ssn\">SSN:</label>\r\n");
      out.write("            <input type=\"number\" class=\"form-control\" name=\"ssn\" placeholder=\"SSN\" id=\"ssn\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group col-md-8\">\r\n");
      out.write("            <label for=\"email\">E-mail:</label>\r\n");
      out.write("            <input type=\"email\" class=\"form-control\" name=\"email\" placeholder=\"E-maile\" id=\"email\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group col-md-8\">\r\n");
      out.write("            <label for=\"char\">Characteristic:</label>\r\n");
      out.write("            <textarea  class=\"form-control\" name=\"char\" id=\"char\" placeholder=\"Characteristic of new employee\"></textarea>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group col-md-8\">\r\n");
      out.write("            <label for=\"rate\">Rate:</label>\r\n");
      out.write("            <input type=\"number\" class=\"form-control\" name=\"rate\" placeholder=\"Rate\" id=\"rate\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group col-md-8\">\r\n");
      out.write("            <label for=\"position\" class=\"control-label\">Position</label>\r\n");
      out.write("            <select class=\"form-control\" name=\"position\" id=\"position\">\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </select>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group col-md-8\">\r\n");
      out.write("            <label for=\"department\" class=\"control-label\">Department</label>\r\n");
      out.write("            <select class=\"form-control\" name=\"department\" id=\"department\">\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </select>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-md-12\">\r\n");
      out.write("            <input type=\"submit\" name=\"submit\" value=\"Submit\" class=\"btn btn-info \">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_page_005ffooter_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_page_005fjs_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_page_005fcss_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  page:css
    org.apache.jsp.tag.web.page.css_tag _jspx_th_page_005fcss_005f0 = (new org.apache.jsp.tag.web.page.css_tag());
    _jsp_getInstanceManager().newInstance(_jspx_th_page_005fcss_005f0);
    _jspx_th_page_005fcss_005f0.setJspContext(_jspx_page_context);
    _jspx_th_page_005fcss_005f0.doTag();
    _jsp_getInstanceManager().destroyInstance(_jspx_th_page_005fcss_005f0);
    return false;
  }

  private boolean _jspx_meth_page_005fheader_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  page:header
    org.apache.jsp.tag.web.page.header_tag _jspx_th_page_005fheader_005f0 = (new org.apache.jsp.tag.web.page.header_tag());
    _jsp_getInstanceManager().newInstance(_jspx_th_page_005fheader_005f0);
    _jspx_th_page_005fheader_005f0.setJspContext(_jspx_page_context);
    // /WEB-INF/jsps/newEmployee.jsp(13,0) name = department type = java.util.ArrayList<com.ariezz.model.Department> reqTime = true required = false fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_page_005fheader_005f0.setDepartment((java.util.ArrayList) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data}", java.util.ArrayList.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    _jspx_th_page_005fheader_005f0.doTag();
    _jsp_getInstanceManager().destroyInstance(_jspx_th_page_005fheader_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/jsps/newEmployee.jsp(52,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("pos");
      // /WEB-INF/jsps/newEmployee.jsp(52,16) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsps/newEmployee.jsp(52,16) '${positions}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${positions}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                    <option>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</option>\r\n");
            out.write("                ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
    } finally {
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    try {
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent(null);
      // /WEB-INF/jsps/newEmployee.jsp(60,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVar("dep");
      // /WEB-INF/jsps/newEmployee.jsp(60,16) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsps/newEmployee.jsp(60,16) '${data}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${data}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                    <option>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dep.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</option>\r\n");
            out.write("                ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
      }
    } finally {
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_page_005ffooter_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  page:footer
    org.apache.jsp.tag.web.page.footer_tag _jspx_th_page_005ffooter_005f0 = (new org.apache.jsp.tag.web.page.footer_tag());
    _jsp_getInstanceManager().newInstance(_jspx_th_page_005ffooter_005f0);
    _jspx_th_page_005ffooter_005f0.setJspContext(_jspx_page_context);
    _jspx_th_page_005ffooter_005f0.doTag();
    _jsp_getInstanceManager().destroyInstance(_jspx_th_page_005ffooter_005f0);
    return false;
  }

  private boolean _jspx_meth_page_005fjs_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  page:js
    org.apache.jsp.tag.web.page.js_tag _jspx_th_page_005fjs_005f0 = (new org.apache.jsp.tag.web.page.js_tag());
    _jsp_getInstanceManager().newInstance(_jspx_th_page_005fjs_005f0);
    _jspx_th_page_005fjs_005f0.setJspContext(_jspx_page_context);
    _jspx_th_page_005fjs_005f0.doTag();
    _jsp_getInstanceManager().destroyInstance(_jspx_th_page_005fjs_005f0);
    return false;
  }
}
