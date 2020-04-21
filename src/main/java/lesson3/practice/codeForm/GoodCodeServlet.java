package lesson3.practice.codeForm;


import javax.servlet.http.HttpServletRequest;

public class GoodCodeServlet extends BadCodeServlet {
    @Override
    protected String getCode(HttpServletRequest request){
        return (ServletUtilities.filter(super.getCode(request)));
    }
}
