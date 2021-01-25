package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.User;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_0.setPageContext(_jspx_page_context);
      _jspx_th_c_if_0.setParent(null);
      _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.adminprofile == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
      if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("    ");
 response.sendRedirect(request.getContextPath() + "/admin/terminate.html"); 
          out.write('\n');
          int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      out.write('\n');
      out.write('\n');
      bean.User adminprofile = null;
      synchronized (session) {
        adminprofile = (bean.User) _jspx_page_context.getAttribute("adminprofile", PageContext.SESSION_SCOPE);
        if (adminprofile == null){
          adminprofile = new bean.User();
          _jspx_page_context.setAttribute("adminprofile", adminprofile, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <link rel=\"icon\" href=\"favicon.ico\">\n");
      out.write("\n");
      out.write("    <title>FoodyMoody Homepage</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core CSS -->\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom styles for this template -->\n");
      out.write("    <link href=\"css/navbar-fixed-top.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <script src=\"js/ie-emulation-modes-warning.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<!-- Fixed navbar -->\n");
      out.write("    <nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"\"><span class=\"glyphicon glyphicon-home\"></span> <span style=\"color:#FFFF00\">&nbspFOODY MOODY</span></a>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"navbar\" class=\"navbar-collapse collapse\">\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("                    <li><a href=\"/cash/admin/ViewCashServlet\"><span class=\"glyphicon glyphicon-th-list\"></span> View Customer Orders</a></li>\n");
      out.write("                    <li><a href=\"/cash/admin/ManageBackendDataServlet\"><span class=\"glyphicon glyphicon-th-list\"></span> Dish List </a></li> \n");
      out.write("                </ul>\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("\t\t        <a aria-expanded=\"false\" href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-user\"></span> Welcome \n");
      out.write("                            <span style=\"color:#FFFF00\">");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((bean.User)_jspx_page_context.findAttribute("adminprofile")).getFullName())));
      out.write("</span>(Admin) \n");
      out.write("                            <b class=\"caret\"></b>\n");
      out.write("                        </a>\n");
      out.write("\t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("\t\t\t    <li><a href=\"/cash/admin/UserProfileServlet\"><span class=\"glyphicon glyphicon-user\"></span> User Profile</a></li>\n");
      out.write("\t\t\t    <li><a href=\"/cash/admin/SettingServlet\"><span class=\"glyphicon glyphicon-cog\"></span> Setting</a></li>\n");
      out.write("\t\t\t    <li class=\"divider\"></li>\n");
      out.write("\t\t\t    <li><a href=\"/cash/admin/logout.jsp\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div><!--/.nav-collapse -->\n");
      out.write("      </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("    <!-- Main component for a primary marketing message or call to action -->\n");
      out.write("        <div class=\"jumbotron\">\n");
      out.write("            <h1>Cash Web-App example</h1>\n");
      out.write("            <ul>\n");
      out.write("                <li>Responsive application</li>\n");
      out.write("                <li>Bootstrap CSS</li>\n");
      out.write("                <li>MVC\n");
      out.write("                    <ul>\n");
      out.write("                      <li>(M)odel - JavaBeans</li>\n");
      out.write("                      <li>(V)iew - JSP for input and output</li>\n");
      out.write("                      <li>(C)ontroller - Servlet</li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("      \n");
      out.write("        <div class=\"well\">\n");
      out.write("            <h3>Admin Login successful! - Welcome <span style=\"color:#FFFF00\">");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((bean.User)_jspx_page_context.findAttribute("adminprofile")).getFullName())));
      out.write("</span></h3>\n");
      out.write("        </div>\n");
      out.write("      \n");
      out.write("        <footer>\n");
      out.write("            <p>&copy; RBK 2014 - SCJ/SCSJ 2303/3303</p>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("    </div> <!-- /container -->\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core JavaScript\n");
      out.write("    ================================================== -->\n");
      out.write("    <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/vendor/bootstrap.min.js\"></script>\n");
      out.write("    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\n");
      out.write("    <script src=\"js/ie10-viewport-bug-workaround.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
