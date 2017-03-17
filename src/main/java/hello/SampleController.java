package hello;

import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.Properties;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Greetings from Spring Boot";
    }

    @RequestMapping("/Database")
    @ResponseBody
    String postgres(@RequestParam("name") String name) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Properties props = new Properties();
        props.setProperty("user","dinesh");
        props.setProperty("password","football");
        props.setProperty("ssl","true");
        props.setProperty("sslfactory","org.postgresql.ssl.NonValidatingFactory");
        String url = "jdbc:postgresql://localhost:5432/database";
        Connection conn = DriverManager.getConnection(url, props);
        Statement stmt = conn.createStatement();
        ResultSet rset;
        String query = "SELECT name,age,email FROM public.information WHERE name = \'"+name+"\'";
        rset = stmt.executeQuery(query);
        String data ="name = "+rset.getString("name")+"\tage = "+rset.getString("age")+"\t email = "+rset.getString("email");
        conn.close();

        return data;
    }
}

