package jsp_hw._10week;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jsp_hw.DB;

public class ProfessorDAO {

	private static Professor getProfessorFrom(ResultSet resultSet) throws SQLException {
		Professor professor = new Professor();
		professor.setId(resultSet.getInt("id"));
		professor.setProfessorName(resultSet.getString("professorName"));
		professor.setDepartmentId(resultSet.getInt("departmentId"));
		professor.setDepartmentName(resultSet.getString("departmentName"));
        return professor;
    }

    public static List<Professor> findAll() throws Exception {
        String sql = "SELECT s.*, d.departmentName" +
                     " FROM professor s LEFT JOIN department d ON s.departmentId = d.id";
        try (Connection connection = DB.getConnection("student1");
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            ArrayList<Professor> list = new ArrayList<Professor>();
            while (resultSet.next())
                list.add(getProfessorFrom(resultSet));
            return list;
        }
    }

    public static Professor findById(int id) throws Exception {
        String sql = "SELECT s.*, d.departmentName " +
                     " FROM Professor s LEFT JOIN department d ON s.departmentId = d.id" +
                     " WHERE s.id = ?";
        try (Connection connection = DB.getConnection("student1");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return getProfessorFrom(resultSet);
                } else {
                	Professor professor = new Professor();
	        		professor.setId(0);
	        		professor.setProfessorName("");
	        		professor.setDepartmentId(0);
	        		professor.setDepartmentName("");
	                return professor;
                }
            }
        }
    }

    public static void insert(Professor professor) throws Exception {
        String sql = "INSERT professor (id, professorName, departmentId)" +
                     " VALUES (?, ?, ?)";
        try (Connection connection = DB.getConnection("student1");
             PreparedStatement statement = connection.prepareStatement(sql)) {
        	statement.setInt(1, professor.getId());
        	statement.setString(2, professor.getProfessorName());
            statement.setInt(3, professor.getDepartmentId());
            statement.executeUpdate();
        }
    }

    public static void update(Professor professor) throws Exception {
        String sql = "UPDATE professor SET id=?, professorName=?, departmentId=?" +
                     " WHERE id = ?";
        try (Connection connection = DB.getConnection("student1");
             PreparedStatement statement = connection.prepareStatement(sql)) {
        	statement.setInt(1, professor.getId());
        	statement.setString(2, professor.getProfessorName());
            statement.setInt(3, professor.getDepartmentId());
            statement.executeUpdate();
        }
    }

}
