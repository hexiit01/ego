package com.xdqx.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.xdqx.pojo.Pic;
import com.xdqx.service.PicService;

@Controller
public class PicController {
	@Resource
	private PicService picService;
	@RequestMapping("insert")
	public String insert(MultipartFile file,HttpServletRequest req) {
		try {
			//ÎÄ¼þ±£´æ
			FileUtils.copyInputStreamToFile(file.getInputStream(), 
					new File(req.getServletContext().getRealPath("files"),
					file.getOriginalFilename()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pic pic =new Pic();
		pic.setPath(file.getOriginalFilename());
		int index=picService.insPic(pic);
		if(index>0) {
			return "redirect:/show";
		}else {
			return "/add.jsp";
		}
	}
	
	@RequestMapping("show")
	public String Show(Model model) {
		model.addAttribute("list",picService.show());
		return "/main.jsp";
	}
	@RequestMapping("delete")
	public String delete(int id) {
		int index=picService.delById(id);
		return "redirect:/show";
	}
	
}
