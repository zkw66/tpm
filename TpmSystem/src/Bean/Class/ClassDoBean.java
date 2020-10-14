package Bean.Class;
import java.sql.*;

public class ClassDoBean {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    public void getConnection(){               //连接数据库
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tpm?characterEncoding=UTF-8";
            String user = "root";
            String password = "123456";
            con = DriverManager.getConnection(url, user, password);
        }
        catch(Exception e){
            System.out.println("数据库连接不上。");
        }
    }

    public String SearchPas(String uname){
        String sqlstr="select password from manager where name = ?";
        String password = "";
        try {
            stm = con.prepareStatement(sqlstr);
            stm.setString(1,uname);
            rs = stm.executeQuery();
            rs.next();
            password = rs.getString(1);
        }catch (Exception e) {
            System.out.println(e);
        }
        return password;
    }

    public void Close()       //关闭数据库
    {
        try {
            stm.close();
            con.close();
        }catch (Exception e) {
        }
    }
}
