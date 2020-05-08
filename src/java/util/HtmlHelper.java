/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author sonnt
 */
public class HtmlHelper {

    public static String hyperlink(String label, String href) {
        // return "<a class=\"page_hyperlink\" href=\""+href+"\">" + label + "</a>"; //1
        return "<li class=\"page-item\"><a class=\"page-link\" href=\"" + href + "\">" + label + "</a></li>";
    }

    public static String pager(int pageindex, int pagecount, int gap) {
        String result = "";
        if (pageindex > gap + 1) {
            result += hyperlink("First", "product?page=" + 1);
        }

        for (int i = gap; i > 0; i--) {
            if (pageindex - gap > 0) {
                result += hyperlink("" + (pageindex - i), "product?page=" + (pageindex - i));
            }
        }

        //result += "<li class=\"page-item active\">" + pageindex + "</li>";
        result += "    <li class=\"page-item active\">\n"
                + "      <a class=\"page-link\" >" + pageindex + "<span class=\"sr-only\"></span></a>\n"
                + "    </li>";

        for (int i = 1; i <= gap; i++) {
            if (pageindex + gap < pagecount+1) {
                result += hyperlink("" + (pageindex + i), "product?page=" + (pageindex + i));
            }
        }

        if (pageindex + gap < pagecount) {
            result += hyperlink("Last", "product?page=" + pagecount);
        }
        System.out.println(result);
        return result;
    }
}
