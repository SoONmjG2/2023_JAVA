
package Collection;

public class student {
	private String name;
	private int num;
	private double score;
	
	public student(String name, int num, double score) {
		this.name=name;
		this.num=num;
		this.score=score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num=num;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score=score;
	}
	
}
