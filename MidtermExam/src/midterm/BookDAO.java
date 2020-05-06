package midterm;

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
                Book book = new Book();
                book.setId(resultSet.getInt("userid"));
                book.setTitle(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("email"));
                book.setCategoryId(resultSet.getInt("departmentName"));
                book.setPrice(resultSet.getString("userType"));
                book.setPublisher(resultSet.getString("pushlisher"));
                list.add(book);
            }
            return list;
        }
    }
}