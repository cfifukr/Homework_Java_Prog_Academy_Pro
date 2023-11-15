package homework1.homework1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;




@WebServlet(name = "formServlet", value = "/form")
public class FormServlet extends HttpServlet {
     private static Map<String, Integer> genderStat = new HashMap<>();
     private final static String[] genders = {"male", "female", "privateInformation", "mechanic"};
     private final static String[] occupations = {"schoolboy", "student", "unemployed", "employed"};
     private static Map<String, Integer> occupationStat = new HashMap<>();

    public FormServlet() {

    }

    public Map<String, Integer> getGenderStat() {
        return genderStat;
    }

    public Map<String, Integer> getOccupationStat() {
        return occupationStat;
    }

    public void updateGenderStat(String gender){
        if (genderStat.size() == 0){
            for(String i : genders){
                genderStat.put(i, 0);
            }
        }

        genderStat.put(gender, genderStat.get(gender) + 1);

    }
    public void updateOccupationStat(String occup){
        if (occupationStat.size() == 0){
            for(String i : occupations){
                occupationStat.put(i, 0);
            }
        }
        occupationStat.put(occup, occupationStat.get(occup) + 1);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.sendRedirect("form.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gender = req.getParameter("gender");
        String occupation = req.getParameter("occupation");
        if(gender != null && occupation != null){
            updateOccupationStat(occupation);
            updateGenderStat(gender);
            resp.sendRedirect(req.getContextPath() + "/stat");
        }else{
            resp.sendRedirect("form.jsp");
        }

    }
}