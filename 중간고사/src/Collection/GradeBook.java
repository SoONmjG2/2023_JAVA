package Collection;

import java.awt.print.Book;
import java.util.ArrayList;

public class GradeBook {
	private ArrayList<Book> arrayList;
	
	public GradeBook() {
		arrayList= new ArrayList<Book> ();
	}
		
	public void averageBook(Book book) {
		int size=arrayList.size();
		int avg=0;
		int sum=0;
		
		for (int i=0;i<size;i++) {
			
		}
		
	}
	
	public void peekBook(int num) {
		for (int i=0; i < arrayList.size();i++) {
			Book book = arrayList.get(i);
			int num1 =book.getNum();
			if (num1==num) {
				return ;
				
			}
		}
		
	}
	
	public void showAllStudnet() {
		for(Book book:arrayList) {
			System.out.println(book);
		}
		System.out.println();
	}
	

}
