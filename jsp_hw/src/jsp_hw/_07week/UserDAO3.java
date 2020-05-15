package jsp_hw._07week;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jsp_hw.DB;
import jsp_hw._06week.User;

public class UserDAO3 {
	private static User getUserFrom(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setId(resultSet.getInt("id"));
		user.setName(resultSet.getString("name"));
		user.setDepartmentId(resultSet.getInt("departmentId"));
		user.setDepartmentName(resultSet.getString("departmentName"));
		user.setEmail(resultSet.getString("departmentId"));
		user.setUserType(resultSet.getString("departmentId"));

		return user;
	}

	public static List<User> findAll() throws Exception {
		String sql = "SELECT u.*, d.departmentName " + "FROM User u LEFT JOIN department d ON u.departmentId = d.id";
		try (Connection connection = DB.getConnection("student1");
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery()) {
			ArrayList<User> list = new ArrayList<User>();
			while (resultSet.next()) {
				User user = new User();
                user.setUserid(resultSet.getString("userid"));
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setDepartmentName(resultSet.getString("departmentName"));
                user.setUserType(resultSet.getString("userType"));
				list.add(user);
			}
			return list;
		}

	}

	public static List<User> findByName(String name) throws Exception {
		String sql = "SELECT u.*, d.departmentName " + "FROM User u LEFT JOIN department d ON u.departmentId = d.id "
				+ "WHERE u.name LIKE ?";
		try (Connection connection = DB.getConnection("student1");
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, name + "%");
			try (ResultSet resultSet = statement.executeQuery()) {
				ArrayList<User> list = new ArrayList<User>();
				while (resultSet.next()) {
					User user = new User();
					user.setId(resultSet.getInt("id"));
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

	public static User findById(int id) throws Exception {
		String sql = "SELECT u.*, d.departmentName " + "FROM User u LEFT JOIN department d ON u.departmentId = d.id "
				+ "WHERE u.id = ?";
		try (Connection connection = DB.getConnection("student1");
			PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				User user = new User();
				if (resultSet.next()) {
					user.setId(resultSet.getInt("id"));
					user.setName(resultSet.getString("name"));
					user.setDepartmentId(resultSet.getInt("departmentId"));
					user.setDepartmentName(resultSet.getString("departmentName"));
					user.setEmail(resultSet.getString("email"));
					user.setUserType(resultSet.getString("userType"));
					return user;
				} else
					return null;
			}
		}
	}

}