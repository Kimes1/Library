package pl.kimes;

public class Main {

	public static void main(String[] args) {
		Library library = new Library();

		Book b = new Book("Sample Book", "2017", "Sample Author");
		Book b2 = new Book("Another Sample Book", "2017", "Different Sample Author");
		Book b3 = new Book("Sample Book", "2017", "Sample Author");
		Book b4 = new Book("Another Sample Book", "2017", "Different Sample Author");
		Book b5 = new Book("Unknown Book", "2010", "Unknown");

		library.addBook(b);
		library.addBook(b2);
		library.addBook(b3);
		library.addBook(b4);
		library.addBook(b5);
	
		
		library.getAllBooks();
		

	}

}
