package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("        <title>Đăng nhập</title>\n");
      out.write("        <!-- Optional JavaScript -->\n");
      out.write("        <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/boot\">\n");
      out.write("        <script src=\"js/jquery-3.4.1.min.js\"></script>\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"owl.carousel.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"owl.theme.default.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"owl.carousel.js\"></script>\n");
      out.write("        <script src=\"owl.carousel.min.js\"></script>\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            #footer {\n");
      out.write("                position:relative;\n");
      out.write("                bottom:0;\n");
      out.write("                width:100%;\n");
      out.write("                height:100px;   /* Height of the footer */\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light\" style=\"background-color: #0099FF\">\n");
      out.write("            <div class=\"container\">\t\t\t\t\t\n");
      out.write("                <a class=\"navbar-brand\" style=\"color: #faf7fd; margin-left: -100px\"><span class=\"badge badge-light\" data-toggle=\"tooltip\" data-spy=\"scroll\" data-target=\"#my-menu\" id=\"album\" style=\"color: #0099FF; font-size: 1.2rem\">Điện Máy Mạnh Kiên</span></a>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                    <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"login.jsp\" style=\"color: #faf7fd; font-size: 1.1rem\">Trang chủ</a>\n");
      out.write("                        </li>\t\n");
      out.write("                    </ul>\t\n");
      out.write("\n");
      out.write("                    <a href=\"login.jsp\" class=\"btn btn-outline-light\">Đăng nhập</a>\n");
      out.write("                    <a href=\"login.jsp\" class=\"btn btn-outline-light\" style=\"margin-left: 10px\">Đăng ký</a>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\t\t\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- login -->\n");
      out.write("\n");
      out.write("        <div class=\"container\" align=\"center\">\n");
      out.write("\n");
      out.write("            <form action=\"Login\" method=\"POST\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label><b>Tài Khoản:</b></label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"email\" placeholder=\"Nhập tài khoản\" name=\"taikhoan\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"pwd\"><b>Mật Khẩu:</b></label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"pwd\" placeholder=\"Nhập mật khẩu\" name=\"matkhau\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group form-check\">\n");
      out.write("                    <label class=\"form-check-label\">\n");
      out.write("                        <input class=\"form-check-input\" type=\"checkbox\" name=\"remember\"> Remember me\n");
      out.write("                    </label>\n");
      out.write("                </div>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\">ĐĂNG NHẬP</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- end login -->\n");
      out.write("<!--        <div class=\"autoslidelogo\">\n");
      out.write("            <div class=\"owl-carousel owl-theme\">\n");
      out.write("                <div class=\"item\">\n");
      out.write("                    <div class=\"img\">\n");
      out.write("                        <img src=\"C:\\Users\\asus\\Documents\\NetBeansProjects\\SieuThiDienMayMKKKKKKK\\web\\thuongHieu\\Daikin_Logo.jpg\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"item\">\n");
      out.write("                    <div class=\"img\">\n");
      out.write("                        <img src=\"C:\\Users\\asus\\Documents\\NetBeansProjects\\SieuThiDienMayMKKKKKKK\\web\\thuongHieu\\download.jpg\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"item\">\n");
      out.write("                    <div class=\"img\">\n");
      out.write("                        <img src=\"C:\\Users\\asus\\Documents\\NetBeansProjects\\SieuThiDienMayMKKKKKKK\\web\\thuongHieu\\download.png\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"item\">\n");
      out.write("                    <div class=\"img\">\n");
      out.write("                        <img src=\"C:\\Users\\asus\\Documents\\NetBeansProjects\\SieuThiDienMayMKKKKKKK\\web\\thuongHieu\\samsung-logo-black-transparent.png\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"item\">\n");
      out.write("                    <div class=\"img\">\n");
      out.write("                        <img src=\"C:\\Users\\asus\\Documents\\NetBeansProjects\\SieuThiDienMayMKKKKKKK\\web\\thuongHieu\\sanyo.jpg\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"item\">\n");
      out.write("                    <div class=\"img\">\n");
      out.write("                        <img src=\"C:\\Users\\asus\\Documents\\NetBeansProjects\\SieuThiDienMayMKKKKKKK\\web\\thuongHieu\\sharp.png\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"item\">\n");
      out.write("                    <div class=\"img\">\n");
      out.write("                        <img src=\"C:\\Users\\asus\\Documents\\NetBeansProjects\\SieuThiDienMayMKKKKKKK\\web\\thuongHieu\\download.png\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\t\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        $('.slideauto .owl-carousel').owlCarousel({\n");
      out.write("            loop: true,\n");
      out.write("            margin: 10,\n");
      out.write("            /*có thêm nút di chuyển nav:true,*/\n");
      out.write("            rewind: true,\n");
      out.write("            autoplaySpeed: 1000, /*điều chỉnh tốc độ phát*/\n");
      out.write("            autoplay: true, /*tự động phát*/\n");
      out.write("            navSpeed: 1000, /*tốc độ điêu hướng*/\n");
      out.write("            responsive: {\n");
      out.write("                0: {\n");
      out.write("                    items: 3\n");
      out.write("                },\n");
      out.write("                600: {\n");
      out.write("                    items: 3\n");
      out.write("                },\n");
      out.write("                1000: {\n");
      out.write("                    items: 3\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("        $('.autoslidelogo .owl-carousel').owlCarousel({\n");
      out.write("            loop: true,\n");
      out.write("            margin: 10,\n");
      out.write("            /*có thêm nút di chuyển nav:true,*/\n");
      out.write("            rewind: true,\n");
      out.write("            autoplaySpeed: 1000, /*điều chỉnh tốc độ phát*/\n");
      out.write("            autoplay: true, /*tự động phát*/\n");
      out.write("            navSpeed: 1000, /*tốc độ điêu hướng*/\n");
      out.write("            responsive: {\n");
      out.write("                0: {\n");
      out.write("                    items: 1\n");
      out.write("                },\n");
      out.write("                600: {\n");
      out.write("                    items: 1\n");
      out.write("                },\n");
      out.write("                1000: {\n");
      out.write("                    items: 6\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("    </script>-->\n");
      out.write("</body>\n");
      out.write("</html>");
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
