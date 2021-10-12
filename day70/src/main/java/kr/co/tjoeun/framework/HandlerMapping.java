package kr.co.tjoeun.framework;

public class HandlerMapping {

	public void loading() {
		String path="";
//		this.getClass().getClassLoader().getResourceAsStream(path); //파일실행
         System.out.println(this.getClass().getClassLoader()
        		 .getResource(path)); //상대경로 써야함
	}
}
