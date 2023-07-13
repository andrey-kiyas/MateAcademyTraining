package MateAcademy.DataBase;

import MateAcademy.DataBase.models.LiteraryFormat;
import MateAcademy.DataBase.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MainDB {
    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();
        Statement getAllFormatsStatement = null;
        try {
            getAllFormatsStatement = connection.createStatement();
            ResultSet resultSet = getAllFormatsStatement
                    .executeQuery("SELECT * FROM literary_formats");
            while (resultSet.next()){
                String format = resultSet.getString("format");
                Long id = resultSet.getObject("id", Long.class);
                LiteraryFormat literaryFormat = new LiteraryFormat();
                literaryFormat.setId(id);
                literaryFormat.setTitle(format);
                System.out.println(literaryFormat);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't get all formats from DB", e);
        }

    }
}
