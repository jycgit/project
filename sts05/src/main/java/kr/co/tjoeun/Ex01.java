package kr.co.tjoeun;

enum En{
	start, end;
}

public class Ex01 {

	static int start=1;
	static int end=0;
	
	public static void main(String[] args) {
      func1(En.end);	

	}
	
	public static void func1(En en) {
		if(en==En.start) System.out.println("½ÇÇà");
	}

}
