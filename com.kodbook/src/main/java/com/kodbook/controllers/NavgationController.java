package com.kodbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kodbook.entities.Post;
import com.kodbook.entities.User;
import com.kodbook.services.PostService;
import com.kodbook.services.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NavgationController {

	@Autowired
	UserService service;
	
	@Autowired
	PostService postService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/openSignUp")
	public String openSignUp() {
		return "signUp";
	}
	
	@GetMapping("/openNewPost")
	public String createPost() {
		return "createPost";
	}
	
	@GetMapping("/goHome")
	public String login(Model model)	{
			List<Post> allPosts = postService.fetchAllPosts();
			model.addAttribute("allPosts", allPosts);
			return "home";
	}

	@GetMapping("/openMyProfile")
	public String openMyProfile(Model model,HttpSession session) {
		String username = (String)session.getAttribute("username");
		User user = service.getUser(username);
		model.addAttribute("user", user);
		return "myProfile";
	}
	
	@GetMapping("/openEditProfile")
	public String openEditProfile() {
		return "editProfile";
	}
	

	@GetMapping("/openIndex")
	public String openIndex() {
		return "index";
	}
}
