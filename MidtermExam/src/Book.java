public class Book {

	int id;
    String title;
    String author;
    int categoryId;
    String price;
    String publisher;

    public Book(int id, String title, String author, int categoryId, String price, String publisher) {
        this.id = id;
        this.title= title;
        this.author = author;
        this.categoryId = categoryId;
        this.price = price;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
    	this.author = author;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
    	this.categoryId = categoryId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
    	this.price = price;
    }

    public String getpublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
    	this.publisher = publisher;
    }

}