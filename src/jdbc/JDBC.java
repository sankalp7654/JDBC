package jdbc;

import java.sql.*;

public class JDBC
{
    public static void main(String args[]) throws Exception
    {
      
        String url="jdbc:mysql://localhost:3306/student";
        String uname="root";
        String pass="root";
        
        //start
        long lStartTime = System.nanoTime();

        
        String query="select * from stud_details where stud_id = 2";	
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        rs.next();
        String name = rs.getString("stud_name");
        System.out.println(name);
        
        //end
        long lEndTime = System.nanoTime();

  		//time elapsed
        long output = lEndTime - lStartTime;

        System.out.println("Elapsed time in milliseconds: " + output / 1000000);

        
        
        st.close();
        con.close();
        }
     
        
       
        catch (Exception e)
        {
            System.out.println("Error: "+e);
        }
    }   
}
