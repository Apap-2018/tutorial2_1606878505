package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping("/viral")
	public String index() {

		// Return viral.html
		return "viral";
	}
	
	@RequestMapping("/challange")
	public String challange(@RequestParam(value = "name") String name, Model model) {
		
		// Add name's value into model and return challange.html
		model.addAttribute("name", name);
		return "challange";
	}
	
	@RequestMapping("/challange/{name}")
	public String challangePath(@PathVariable String name, Model model) {
		
		// like before but using request path
		model.addAttribute("name", name);
		return "challange";
	}
	
	@RequestMapping("/generator")
	public String viralGenerator(@RequestParam(value = "a", required = false, defaultValue = "0") String value_a, 
									@RequestParam(value= "b", required = false, defaultValue = "0") String value_b, 
									Model model) {
		
		// Adding value_a and value_b into model
		model.addAttribute("value_a", value_a);
		model.addAttribute("value_b", value_b);
		
		// Processing output for viral_generator.html
		int a = Integer.parseInt(value_a);
		int b = Integer.parseInt(value_b);
		System.out.println(value_b);
		String output = "h";
		
		if (a <= 1) {									
			
			// Assumption if input a <= 0 treated as a == 1
			output = output + "m";
		}
		
		else {
			
			// Iterate for adding a times "m" into output
			for (int i = 0; i < a; i++) {
				output += "m";
			}						
		}
		
		if (b <= 1) {
			
			// Assumption if input b <= 0 treated as b == 1
			model.addAttribute("output", output);
		}
		
		else {
			String finalOutput = "";
			
			// Iterate for adding b times output into finalOutput
			for (int i = 0; i < b; i++) {
				finalOutput += output;
				if (i != b) {
					finalOutput += " ";
				}
			}
			model.addAttribute("output", finalOutput);
		}
					
		return "viral_generator";
	}
}
