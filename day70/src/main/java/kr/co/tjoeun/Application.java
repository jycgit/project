package kr.co.tjoeun;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Application {

	public static void main(String[] args) throws Exception {
		// run embeded tomcat, 메인실행시 서버가 자동실행
		File file=new File("./src/main/webapp");
		System.out.println(file.getCanonicalPath());
		Tomcat tomcat=new Tomcat();
		tomcat.setPort(8080);
		tomcat.addWebapp("/day70/", file.getCanonicalPath());
		tomcat.start();
		tomcat.getServer().await();
	}

}
