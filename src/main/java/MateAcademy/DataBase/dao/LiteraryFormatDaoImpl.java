package MateAcademy.DataBase.dao;

import MateAcademy.DataBase.models.LiteraryFormat;
import MateAcademy.DataBase.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LiteraryFormatDaoImpl implements LiteraryFormatDao {
    @Override
    public List<LiteraryFormat> getAll() {
        List<LiteraryFormat> allFormatList = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
             Statement getAllFormatsStatement = connection.createStatement()
        ) {
            ResultSet resultSet = getAllFormatsStatement
                    .executeQuery("SELECT * FROM literary_formats WHERE is_deleted = false");
            while (resultSet.next()) {
                String format = resultSet.getString("format");
                Long id = resultSet.getObject("id", Long.class);
                boolean is_deleted = resultSet.getObject("is_deleted", Boolean.class);
                LiteraryFormat literaryFormat = new LiteraryFormat();
                literaryFormat.setId(id);
                literaryFormat.setFormat(format);
                literaryFormat.setDeleted(is_deleted);
//                System.out.println(literaryFormat);
                allFormatList.add(literaryFormat);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't get all formats from DB", e);
        }
        return allFormatList;
    }

    @Override
    public LiteraryFormat create(LiteraryFormat format) {
        String insertFormatRequest = "INSERT INTO literary_formats(format) values(?);";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createFormatStatement = connection
                     .prepareStatement(insertFormatRequest, Statement.RETURN_GENERATED_KEYS)
        ) {
            createFormatStatement.setString(1, format.getFormat());
            createFormatStatement.executeUpdate();
            ResultSet generatedKeys = createFormatStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                format.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't insert format to DB", e);
        }
        return format;
    }

    @Override
    public boolean delete(Long id) {
        String deleteRequest = "UPDATE literary_formats SET is_deleted = true WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createFormatStatement = connection
                     .prepareStatement(deleteRequest, Statement.RETURN_GENERATED_KEYS)
        ) {
            createFormatStatement.setLong(1, id);
            return createFormatStatement.executeUpdate() >= 1;
        } catch (SQLException e) {
            throw new RuntimeException("Can't insert format to DB", e);
        }
    }
}
