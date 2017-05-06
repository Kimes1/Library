package pl.kimes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

	private int uniqueID;
	private Map<Integer, Book> bookMap = new HashMap<>();
	private Map<Book, Integer> copiesMap = new HashMap<>();
	private Map<Book, List<String>> borrowersMap = new HashMap<>();

	public void addBook(Book newAddbook) {
		Integer id = ++uniqueID;
		for (Book book : bookMap.values()) {
			if (book.equals(newAddbook)) {
				int numberOfCopies = getNumberOfCopies(newAddbook);
				newAddbook.setId(id);
				numberOfCopies++;
				bookMap.put(id, newAddbook);
				copiesMap.put(newAddbook, numberOfCopies);
				return;
			}
		}
		int numberOfCopies = 1;
		newAddbook.setId(id);
		bookMap.put(id, newAddbook);
		copiesMap.put(newAddbook, numberOfCopies);
	}

	public void lendBook(Integer bookID, String borrowersName) {
		Book bookValues = bookMap.get(bookID);
		int numberOfCopies = copiesMap.get(bookValues);
		if (numberOfCopies == 0) {
			System.out.println("Can't lend this book, it's been alredy borrowed by "
					+ borrowersMap.get(bookValues).toString().replace("[", "").replace("]", ""));
		} else {
			List<String> borrowersList = borrowersMap.get(bookValues);
			if (borrowersList == null) {
				borrowersList = new ArrayList<>();
				borrowersMap.put(bookValues, borrowersList);
			}
			borrowersList.add(borrowersName);

			copiesMap.put(bookValues, copiesMap.get(bookValues) - 1);

		}
	}

	public void returnBook(Integer bookID, String returnersName) {
		Book bookValues = bookMap.get(bookID);
		List<String> borrowersList = borrowersMap.get(bookValues);
		if (borrowersList == null) {
			System.out.println("This book wasn't borrowed by you, you can't return it");
			return;
		}
		if (!borrowersList.contains(returnersName)) {
			System.out.println("Invalid name");
		}

		borrowersList.remove(returnersName);
		copiesMap.put(bookValues, copiesMap.get(bookValues) + 1);
	}

	public void removeBook(Integer bookID) {
		Book bookValues = bookMap.get(bookID);
		if (bookValues != null) {
			if (borrowersMap.get(bookValues) == null) {
				bookMap.remove(bookID);
				copiesMap.put(bookValues, copiesMap.get(bookValues) - 1);
			} else {
				System.out.println("Can't remove that book right now, it's lent");
			}
		} else {
			System.out.println("Invalid ID number");

		}
	}

	public void getInfoByID(Integer bookID) {
		Book book = bookMap.get(bookID);
		if (book != null) {
			book.print();
			printCopies(book);
		}
	}

	public void getAllBooks() {
		for (Book book : bookMap.values()) {
			book.print();
			printCopies(book);
		}
	}

	public void getAllByTitle(String title) {
		for (Book book : bookMap.values()) {
			if (title.equals(book.getTitle())) {
				book.print();
				printCopies(book);
			}
		}

	}

	public void getAllByAuthor(String author) {
		for (Book book : bookMap.values()) {
			if (author.equals(book.getAuthor())) {
				book.print();
				printCopies(book);
			}
		}
	}

	public void getAllByYear(String year) {
		for (Book book : bookMap.values()) {
			if (year.equals(book.getYear())) {
				book.print();
				printCopies(book);
			}
		}
	}

	public void getAllByAuthorAndYear(String author, String year) {
		for (Book book : bookMap.values()) {
			if (author.equals(book.getAuthor()) && (year.equals(book.getYear()))) {
				book.print();
				printCopies(book);
			}
		}
	}

	private void printCopies(Book book) {
		copiesMap.get(book);
		System.out.println("Number of copies: " + getNumberOfCopies(book));

	}

	private int getNumberOfCopies(Book book) {
		return copiesMap.get(book);

	}

}
