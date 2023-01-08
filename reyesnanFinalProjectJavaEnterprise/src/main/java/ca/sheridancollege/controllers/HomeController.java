package ca.sheridancollege.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Cart;
import ca.sheridancollege.beans.Product;
import ca.sheridancollege.beans.User;
import ca.sheridancollege.database.DataBaseAcces;


@Controller
public class HomeController {
	

	
	@Autowired
	@Lazy
	private DataBaseAcces da;
	
	@GetMapping("/")
	public String goHome(Model model,HttpSession sesion) {
			model.addAttribute("productList", da.getProductsList());
			model.addAttribute("product", new Product());
			return "index.html";
	}

	
	@GetMapping("/user")
	public String goHomeUser(Model model,HttpSession sesion) {
		
			model.addAttribute("productList", da.getProductsList());
			model.addAttribute("product", new Product());
				
			return "/user/index.html";
	}
	
	
	@GetMapping("/addProductById/{productId}")
	public String goAddProduct(Model model,
			@PathVariable int productId, Product product,HttpSession sesion) {
			model.addAttribute("product", new Product());
			System.out.print(productId);
			System.out.print(da.getProductsList().get(productId));
			model.addAttribute("productList", da.getProductsList());
			
			
			Product p = da.getProductsList().get(productId);
			String description=p.getDescription();
			String name = p.getNameProduct();
			int price = p.getPrice();
			da.insertCart(name, description, price);
						
			return "/user/index.html";
	}
	
	@GetMapping("/removeProductById/{productId}")
	public String goRemoveProduct(Model model,@PathVariable Long productId,
			HttpSession sesion) {
			da.removeProductById(productId);
			
			model.addAttribute("product", new Cart());
			model.addAttribute("List", da.getCartList());
			System.out.print(productId);
			return "/user/cart.html";}
		
	@GetMapping("/viewProduct")
	public String goViewProduct(Model model,@ModelAttribute Cart cart,
			HttpSession sesion) {
			model.addAttribute("List",da.getCartList());
			model.addAttribute("product", new Cart());
			return "/user/cart.html";
	}
		
		
	@GetMapping("/admin")
	public String goHomeAdmin(Model model,@ModelAttribute Product product,
			HttpSession sesion) {
			model.addAttribute("productList", da.getProductsList());
			model.addAttribute("product", new Product());
			return "/admin/admin.html";
			
	}
	
	@GetMapping("/deleteProductById/{productId}")
	public String goDeleteAdmin(Model model,@PathVariable Long productId,
			HttpSession sesion) {
			da.deleteProductById(productId);
			
			model.addAttribute("product", new Product());
			model.addAttribute("productList", da.getProductsList());
			System.out.print(productId);
			return "/admin/admin.html";
			
	}
	
	@GetMapping("/Product")
	public String goAddProduct(Model model,@ModelAttribute Product product,HttpSession sesion) {
			model.addAttribute("productList", da.getProductsList());
			model.addAttribute("product", new Product());
		
			return "/admin/product.html";}
	
	
	@PostMapping("/insertProduct")
	public String goInsertProduct(Model model,@ModelAttribute Product product) {
		
			da.insertProduct(product);	
		
			model.addAttribute("productList", da.getProductsList());
			model.addAttribute("product", new Product());
					
			return "redirect:/admin";}		
	
	
	@GetMapping("/login")
	public String goLoginPage(HttpSession sesion) {
		   return "login.html";
	}

	@GetMapping("/access-denied")
	public String goAccessDenied() {
		   return "/error/access-denied.html";
	}
	
	@GetMapping("/register")
	public String goRegistration(HttpSession sesion) {
		  return "registration.html";
	}
	
	@PostMapping("/register")
	public String processRegistration(HttpSession sesion,@RequestParam String name,
			@RequestParam String password,@RequestParam int roleId ) {
		
		  da.addUser(name,password);
		  long userId=da.findUserAccount(name).getUserId();
		
		
		    if(roleId==2) {
			da.addRole(userId, 2);
			return "redirect:/user";
			}
		
		    else 
		    da.addRole(userId, 1);
		    return "redirect:/admin";
		
	}
	
	
	
	
	
	
	



}
