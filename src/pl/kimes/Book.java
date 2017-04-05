package pl.kimes;

import java.util.Objects;

public class Book {

	private int id;
	private String title;
	private String year;
	private String author;

	public Book(String title, String year, String author) {
		this.title = title;
		this.year = year;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getAuthor() {
		return author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void print() {
		System.out.println("-----");
		System.out.println("ID number: " + this.getId());
		System.out.println("Title: " + this.getTitle());
		System.out.println("Year: " + this.getYear());
		System.out.println("Author: " + this.getAuthor());
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, title, year);
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Book)) {
			return false;
		}
		Book book = (Book) obj;

		return Objects.equals(title, book.getTitle()) && Objects.equals(author, book.getAuthor())
				&& Objects.equals(year, book.getYear());
	}

}
