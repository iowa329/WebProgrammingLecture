package midterm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public static List<Book> findAll() throws Exception {
    	String sql = "SELECT * FROM book.category; " +
    			"SELECT b.*, c.categoryName FROM book b LEFT JOIN category c ON b.categoryId = c.id;";
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