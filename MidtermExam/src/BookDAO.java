import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public static List<Book> findAll() throws Exception {
    	String sql = "SELECT u.*, d.departmentName " + "FROM user u LEFT JOIN department d ON u.departmentId = d.id";
        try (Connection connection = DB.getConnection("book");
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            ArrayList<Book> list = new ArrayList<Book>();
            while (resultSet.next()) {
                User user = new User();
                user.setUserid(resultSet.getString("userid"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setDepartmentName(resultSet.getString("departmentName"));
                user.setUserType(resultSet.getString("userType"));
                list.add(user);
            }
            return list;
        }
    }
}