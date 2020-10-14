package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import Bean.Admin.AdminBean;
import Bean.Admin.AdminDoBean;
import Bean.Class.ClassBean;
import Bean.Class.ClassDoBean;
import Bean.Prof.ProfBean;
import Bean.Prof.ProfDoBean;

@WebServlet(name = "LoginServlet",urlPatterns = "/DoLogin")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        String uname = request.getParameter("uname");
        String pas = request.getParameter("pas");
        String password,errora;
        String pan = uname.substring(0,1);
        //判断为可能是管理员登录
        if(pan.equals("A")){
            AdminBean ab = new AdminBean();
            AdminDoBean ad = new AdminDoBean();
            ad.getConnection();
            session.setAttribute("ab",ab);
            password = ad.SearchPas(uname);
            if(password == ""){
                errora = "用户名或者密码错误";
                session.setAttribute("errora",errora);
                response.sendRedirect("ErrorPage/LoginError.jsp");
            }
            else if(password.equals(pas)){
                ab.setAname(uname);
                ab.setApas(pas);
                session.setAttribute("uname",uname);
                response.sendRedirect("AdminPage/Amain.jsp");
            }
            else{
                errora = "登录密码错误";
                session.setAttribute("errora",errora);
                response.sendRedirect("ErrorPage/LoginError.jsp");
            }
            ad.Close();
        }
        //判断为可能是专业负责人登录
        else if(pan.equals("Z")){
            ProfBean pb = new ProfBean();
            ProfDoBean pd = new ProfDoBean();
            pd.getConnection();
            session.setAttribute("pb",pb);
            password = pd.SearchPas(uname);
            if(password == ""){
                errora = "用户名或者密码错误";
                session.setAttribute("errora",errora);
                response.sendRedirect("ErrorPage/LoginError.jsp");
            }
            else if(password.equals(pas)){
                pb.setProname(uname);
                pb.setPropas(pas);
                session.setAttribute("uname",uname);
                response.sendRedirect("ProfPage/Zmain.jsp");
            }
            else{
                errora = "登录密码错误";
                session.setAttribute("errora",errora);
                response.sendRedirect("ErrorPage/LoginError.jsp");
            }
            pd.Close();
        }
        //判断为可能是课程负责人登录
        else if(pan.equals("C")){
            ClassBean cb = new ClassBean();
            ClassDoBean cdb = new ClassDoBean();
            cdb.getConnection();
            session.setAttribute("cdb",cdb);
            password = cdb.SearchPas(uname);
            if(password == ""){
                errora = "用户名或者密码错误";
                session.setAttribute("errora",errora);
                response.sendRedirect("ErrorPage/LoginError.jsp");
            }
            else if(password.equals(pas)){
                cb.setName(uname);
                cb.setPassword(pas);
                session.setAttribute("uname",uname);
                response.sendRedirect("ClassPage/Cmain.jsp");
            }
            else{
                errora = "登录密码错误";
                session.setAttribute("errora",errora);
                response.sendRedirect("ErrorPage/LoginError.jsp");
            }
            cdb.Close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
