package com.toy.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MainPage {
	
	@GetMapping("/")
	public String mainIndex() {
		return "index/index";
	}
	
	
//	user page
	@GetMapping("/login")
	public String login() {
		return "index/login";
	}
	
	@PostMapping("/userMypage")
	public String userMyPage(@RequestBody String id) {
		System.out.println(id);
		return "mypage/mypage";
	}
	
	
}
