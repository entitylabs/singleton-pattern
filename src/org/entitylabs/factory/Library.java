package org.entitylabs.factory;

import java.util.ArrayList;
import java.util.List;

public final class Library implements Cloneable {

	private static Library libraryInstance;

	private List<Book> books;

	public Library() {

		this.books = new ArrayList<>();
	}

	public static Library getInstance() {

		if (libraryInstance == null) {
			libraryInstance = new Library();
		}

		return libraryInstance;
	}

	public void addBook(Book book) {
		this.books.add(book);

	}

	public void removeBook(Book book) {

		if (this.books.contains(book)) {
			this.books.remove(book);
		}

	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books.addAll(books);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {

		return libraryInstance;
	}

}
