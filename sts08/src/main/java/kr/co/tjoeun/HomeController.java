package kr.co.tjoeun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class HomeController {
	String path="D:\\framework\\upload";
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@PostMapping("/upload")
//	public String upload(MultipartFile file1 ,MultipartFile file2 ,String msg){
//		logger.debug(msg);
//		logger.debug(file1.getOriginalFilename());
//		logger.debug(file2.getOriginalFilename());
	public String upload(MultipartHttpServletRequest mreq ,String msg,Model model){
		Enumeration<String> enu = mreq.getParameterNames();
		while(enu.hasMoreElements())
			logger.debug(enu.nextElement());
		MultiValueMap<String, MultipartFile> map = mreq.getMultiFileMap();
		Set<Entry<String, List<MultipartFile>>> set = map.entrySet();
		List<String> downList=new ArrayList<>();
		for(Entry<String, List<MultipartFile>> entry:set) {
			List<MultipartFile> list=entry.getValue();
			String orgin=list.get(0).getOriginalFilename();
			logger.debug(orgin);
			String rename=System.currentTimeMillis()+"_"+orgin;
			if(!orgin.isEmpty())downList.add(rename);
			File file =new File(path+"/"+rename);
			try {
				list.get(0).transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("list", downList);
		return "download";
	}
	
	@GetMapping("/download")
	public void download1(String fname,HttpServletResponse res) throws FileNotFoundException, IOException {
		File file=new File(path+"/"+fname);
		String origin=fname.substring(fname.indexOf("_")+1);
		res.setHeader("Content-Disposition", "attachment; filename=\""+origin+"\"");
		res.setContentType("application/octet-stream");
		try(
			InputStream is=new FileInputStream(file);
			OutputStream os=res.getOutputStream();
				){
			int su=-1;
			while((su=is.read())!=-1)
				os.write(su);
		}
	}
	
	@GetMapping("/download/{fname:.+}")
	public void download2(@PathVariable("fname") String fname
			,HttpServletResponse res ) throws FileNotFoundException, IOException {
		File file=new File(path+"/"+fname);
		String origin=fname.substring(fname.indexOf("_")+1);
		res.setHeader("Content-Disposition", "attachment; filename=\""+origin+"\"");
		res.setContentType("application/octet-stream");
		try(
			InputStream is=new FileInputStream(file);
			OutputStream os=res.getOutputStream();
				){
			int su=-1;
			while((su=is.read())!=-1)
				os.write(su);
		}
	}
}


