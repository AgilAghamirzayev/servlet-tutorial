package lesson3.practice.coreservlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LotteryNumbers extends HttpServlet {
    private long modTime;
    private int[] numbers = new int[10];

    @Override
    public void init() throws ServletException {
        modTime = System.currentTimeMillis()/1000*1000;
        for (int i = 0; i <numbers.length ; i++) {
            numbers[i] = randomNum();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Your Lottery Number";
        String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W#C//DTD HTML 4.0 " +
                        "Transitional//EN\">\n";
        out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                "<B>Based upon extensive research of " +
                "astro-illogical trends, psychic farces, " +
                "and detailed statistical claptrap, " +
                "we have chosen the " + numbers.length +
                " best lottery numbers for you.</B>" +
                "<OL>");

        for (int i = 0; i <numbers.length ; i++) {
            out.println("  <LI>" + numbers[i]);
        }
        out.println("</OL>" + "</BODY></HTML>");
    }

    @Override
    public long getLastModified(HttpServletRequest request){
        return (modTime);
    }

    private int randomNum(){
        return ((int) (Math.random() * 100));
    }
}
