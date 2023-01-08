package ca.sheridancollege.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import ca.sheridancollege.DataArray.DataArray;
import ca.sheridancollege.databaseArray.DatabaseArray;

@Controller
public class ArrayController {
	
	@Autowired JdbcTemplate jdbcTemplate;
	
	@GetMapping("/")
	public String goAddArray(Model model) {
		
		model.addAttribute("dataarray",new DataArray());
		return "User.html";}

	@GetMapping("/add")
	public String doAddArray(Model model,
			@ModelAttribute DataArray array,@ModelAttribute DatabaseArray database) {
				
		array.ArrayGenerate();
		
		DatabaseArray.result.add(array);
		
		model.addAttribute("dataarray",new DataArray());
		
		
			return "User.html";}

				 
	    @GetMapping("/result")
	   public String goResult(Model model,
			@ModelAttribute DataArray array,@ModelAttribute DatabaseArray database) {
	    	
	    	model.addAttribute("result",DatabaseArray.result);
	    	
	        return "infouser.html";
	    }
	    @GetMapping("/array")
		   public String goArray(Model model,
				@ModelAttribute DataArray array,@ModelAttribute DatabaseArray database) {
		    			    	
	    	model.addAttribute("array",DatabaseArray.result);
		    	
			return "array.html";
		    }
	    
	    
	  
	    
}