package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MainController implements Controller {
    private Logger log=Logger.getLogger("kr.co.tjoeun.controller.MainController");
	private String viewName;
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.trace("index.do-trace leval");
		log.debug("index.do-debug level");
		log.info("index.do-info level");
		log.warn("index.do-warn level");
		log.error("index.do-error level");
		log.fatal("index.do-faltal level");
		ModelAndView mav=new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

}
