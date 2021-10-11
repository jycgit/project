package kr.co.tjoeun.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tjoeun.controller.IndexController;

public class DispatchServlet extends HttpServlet {
	Map<String,Controller> handlerMapping=new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		  String path=config.getInitParameter("contextConfigLocation");
		  if(path==null) path="/../servlet/dispatch.properties";
		   //propertiex 파일 reading
				java.util.Properties props=new Properties();
				//InputStream is=new FileInputStream("D:\\framework\\day69\\src\\main\\webapp\\WEB-INF\\servlet\\dispatch.prop");
				InputStream is=this.getClass().getResourceAsStream("/../servlet/dispatch.properties");
				
				//properties 경로

				
				//URL-Controller 등록
				Map<String,Controller> handlerMapping=new HashMap<>();
				Set<Entry<Object, Object>> set = props.entrySet();
				Iterator<Entry<Object, Object>> ite =set.iterator();
				while(ite.hasNext()) {
					Entry<Object, Object> entry=ite.next();
					String key=(String) entry.getKey();
					String value=(String) entry.getValue();
					Controller temp=null;
					try {
					temp = (Controller) Class.forName(value).newInstance();
					} catch (Exception e){
						e.printStackTrace();
					}
					handlerMapping.put(key, temp);
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
    

//		Map<String,String> map=new HashMap<>();
//      map.put("/index.do", "kr.co.tjoeun.controller.IndexController");
//		map.put("/list.do", "");
//		map.put("/add.do", "");
//		map.put("/insert.do", "");
		
		//문서를 읽어서 수행
		String path=req.getRequestURI()
        		    .substring(req.getContextPath().length());
        Controller controller=null;
 //       String info=map.get(path);
 //         String info=props.getProperty(path);
        
 //       try {
//			controller=(Controller) Class.forName(info).newInstance();
///		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
///			e1.printStackTrace();
//		}
       
        // viewresolver
        String prefix="/WEB-INF/views/";
        String suffix=".jsp";
        try {
			String viewName=controller.execute(req);
			if(viewName.startsWith("redirect")) {
				resp.sendRedirect(viewName.substring("redirect:".length()));
				return;
			}
			viewName=prefix+viewName+".jsp";
			req.getRequestDispatcher(viewName).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}	
}

