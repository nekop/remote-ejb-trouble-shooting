package servletSample;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.ejb.HelloEjb;

@WebServlet("/helloworld")
public class ServletSample extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @EJB
    private HelloEjb ejb;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
			this.ejb.hello();
    }
    
}