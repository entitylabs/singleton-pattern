package org.entitylabs.factory.simulator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.entitylabs.factory.Book;
import org.entitylabs.factory.Library;

public class Simulator {

	public static void main(String[] args) {

		Book book1 = new Book("First Book", "12-df-3-55");
		Book book2 = new Book("Second Book", "12-rg-7-45");

		Library library = Library.getInstance();
		Library libraryClone = null;
		Library libraryTwo = Library.getInstance();
		try {
			libraryClone = (Library) library.clone();
		} catch (CloneNotSupportedException exception) {
			exception.printStackTrace();
		}

		library.addBook(book1);
		System.out.println(library.hashCode());
		System.out.println(libraryClone.hashCode());
		System.out.println(libraryTwo.hashCode());
		
		
		System.out.println(libraryTwo.getBooks().toString());
		
		
		// Breaking the pattern with reflection

		Library libraryWithReflection = null;

		try {
			Constructor<Library> constructor = (Constructor<Library>) Library.class.getDeclaredConstructors()[0];
			constructor.setAccessible(true);
			libraryWithReflection = constructor.newInstance();

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException e) {
			e.printStackTrace();
		}
		
		libraryWithReflection.addBook(book2);
		System.out.println(libraryWithReflection.getBooks().toString());
	}
}
