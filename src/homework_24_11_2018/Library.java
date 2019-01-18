package homework_24_11_2018;

public interface Library {
	public void addBook(Book book);

	public boolean deleteBookByName(String bookName);

	public Book findByName(String bookName);

	public void printAllBooks();
}
