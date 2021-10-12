package kr.co.tjoeun.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchServlet extends HttpServlet {
    Map<String, Controller> map=new HashMap<> ();
	
   @Override
public void init(ServletConfig config) throws ServletException {
	new HandlerMapping().loading();
	String file=config.getInitParameter("applicationContext");
	if(file==null)
		file="/WEB-INF/servlet/applicationContext.properties";
	String path=config.getServletContext().getRealPath(file);
	Properties prop=new Properties();
	InputStream inStream=null;
	try {
		inStream = new FileInputStream(path);
		prop.load(inStream);
	} catch (Exception e) {
		e.printStackTrace();
	}
	Set<String> keys=prop.stringPropertyNames();
	for(String key:keys) {
		String info=prop.getProperty(key);
		Controller controller=null;
		try {
			controller=(Controller)Class.forName(info).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(controller!=null) map.put(key, controller);
	}
}
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doDo(req,resp);
	}
	
	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getRealPath("WEB-INF"));
		String url=req.getRequestURI()
				.substring(req.getContextPath().length());
		Controller controller=map.get(url);
		try {
			String viewName = controller.execute(req);
			if(viewName.startsWith("redirect")) {
				resp.sendRedirect(viewName.substring("redirect:".length()));
				return;
			}
			String prefix="/WEB-INF/views/";
			String suffix=".jsp";
			req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
