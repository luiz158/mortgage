package com.mercury.mc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InputController {
	@RequestMapping("/input")
	public String goMain() {
		return "input";
	}
}
