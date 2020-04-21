package lesson3.practice.readingAllParameters;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.stream.Collectors;

public class ShowParameters extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String content = new BufferedReader(new FileReader(new File("content/show.html"))).lines()
                .collect(Collectors.joining("\n"));

        PrintWriter out = resp.getWriter();

        out.write(content);

        String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                        "Transitional//EN\">\n";
        String title = "Reading All Request Parameters";
        out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                "<TABLE BORDER=1 ALIGN=CENTER>\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "<TH>Parameter Name<TH>Parameter Value(s)");

        Enumeration paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()){
            String paramName = (String) paramNames.nextElement();
            out.println("<TR><TD>" + paramName + "\n<TD>");
            String[] paramValues = req.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0) out.println("<I>No Value</I>");
                else out.println(paramValue);
            } else {
              out.println("<UL>");
                for (String paramValue : paramValues) {
                    out.println("<LI>" + paramValue);
                }
                out.println("</UL>");
            }
        }
        out.println("</TABLE>\n</BODY></HTML>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
