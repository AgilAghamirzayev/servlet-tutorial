package lesson3.practice.codeForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class BadCodeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = new BufferedReader(new FileReader(new File("content/CodeForm1.html"))).lines()
                .collect(Collectors.joining("\n"));

      PrintWriter out = response.getWriter();
        out.write(content);


        String title = "Code Sample";
        String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                        "Transitional//EN\">\n";
        out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<PRE>\n" +
                getCode(request) +
                "</PRE>\n" +
                "Now, wasn't that an interesting sample\n" +
                "of code?\n" +
                "</BODY></HTML>");
    }

    protected String getCode(HttpServletRequest request) {
        return(request.getParameter("code"));
    }
}
