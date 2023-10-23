package Set;

import java.util.HashSet;
import java.util.Iterator;
import Collection.Book;

public class BookHashSet {
	private  HashSet<Book> hashSet;
	
	public BookHashSet() {
		hashSet = new HashSet<Book> ();
	}
	
	public void addBook(Book book) {
		hashSet.add(book);
	}
	
	public boolean removeBook(int BookId) {
		Iterator<Book> ir = hashSet.iterator();
	
		while(ir.hasNext()) {
			Book book = ir.next();
			int tempId = book.getBookId();
			if (tempId == BookId) {
				hashSet.remove(book);
				return true;
			}
		}
		System.out.println(BookId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllBook() {
		for(Book book : hashSet) {
			System.out.println(book);
		}
		System.out.println();
	}

}
