
package homework1.homework1;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


@WebServlet(name = "mainServlet", value = "")
public class MainServlet extends HttpServlet{


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.sendRedirect("main.jsp");
    }

}
