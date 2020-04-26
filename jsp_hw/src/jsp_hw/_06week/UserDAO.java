package jsp_hw._06week;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jsp_hw.DB;

public class UserDAO {

    public static List<User> findAll() throws Exception {
    	String sql = "SELECT u.*, d.departmentName " + "FROM user u LEFT JOIN department d ON u.departmentId = d.id";
        try (Connection connection = DB.getConnection("student1");
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            ArrayList<User> list = new ArrayList<User>();
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