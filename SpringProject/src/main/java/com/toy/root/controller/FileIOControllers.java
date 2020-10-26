package com.toy.root.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileIOControllers {

	@GetMapping("/io/fileadd")
	public String fileAdd() {
		return "io/fileadd";
	}
	
	@PostMapping("/io/fileupload")
	public String fileUpload(@RequestParam("filename") MultipartFile mFile) {
		try {
			String path = System.getProperty("user.dir");
			mFile.transferTo(new File(path+"/src/main/resources/resource/img/"+mFile.getOriginalFilename()));
			
			System.out.println("pwd : "+path);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "io/fileupload";
	}
	
}
