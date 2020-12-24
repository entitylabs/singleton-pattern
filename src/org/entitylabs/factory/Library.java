package org.entitylabs.factory;

import java.util.ArrayList;
import java.util.List;

// Making class final ensures class cannot be inherited
public final class Library implements Cloneable {

	// private static reference to the only instance of library
	private static Library libraryInstance = null;

	// List of books inside library
	private List<Book> books;

	// private constructor to control instantiation
	private Library() {

		this.books = new ArrayList<>();
	}

	// This method returns an existing or a new instance based on condition
	public static Library getInstance() {

		// Double lock make the instantiation thread safe
		if (null == libraryInstance) {
			synchronized (Library.class) {
				if (null == libraryInstance) {
					libraryInstance = new Library();
				}

			}
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

	// clone method ensures same instance is returned if user tries to call clone on
	// this class
	@Override
	public Object clone() throws CloneNotSupportedException {

		return libraryInstance;
	}

}
