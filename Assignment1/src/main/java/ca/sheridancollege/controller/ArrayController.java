package ca.sheridancollege.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ca.sheridancollege.array.DataArray;

@Controller
public class ArrayController {
	
	@GetMapping("/")
	public String goAddArray(Model model) {
		model.addAttribute("dataarray",new DataArray());
		return "User.html";
	}
		
	@GetMapping("/add")
	public String doAddArray(Model model,
			@ModelAttribute DataArray array) {
		System.out.println(array.ArrayGenerate());
		
		
		model.addAttribute("dataarray",new DataArray());
		
		// condition to know if our sum value is even or odd
		
		 if(array.getUsern()<=array.getValue1() ||array.getValue2()<=array.getUsery()) {
			 
				 return "infouser.html";  //If it is even it returns the page even.html
				}
					 else return "Error.htm" ;  //If it is even it returns the page odd.html
			}
		
		}


