package org.mcet.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mcet.demo.entity.Product;
import org.mcet.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@CrossOrigin({"*","http://localhost:4200"})
@MultipartConfig
public class HomeController {
	@Autowired
	private ProductRepository pr;
	
	@GetMapping
	public ModelAndView home()
	{
		List<Product> products = pr.findAll();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		mv.addObject("product", new Product());
		mv.addObject("products", products);
		return mv;
	}
	
	@RequestMapping(value = "/btn", method = RequestMethod.POST, params = "add" )
	public ModelAndView add(@Valid @ModelAttribute("product") Product product, BindingResult br)
	{
		if(br.hasErrors())
		{
			List<Product> products = pr.findAll();
			ModelAndView mv=new ModelAndView();
			mv.setViewName("index");
			mv.addObject("product", product);
			mv.addObject("products", products);
			return mv;			
		}else
		{
			pr.save(product);
		}
		return home();
	}
	
	
	@RequestMapping(value = "/btn", method = RequestMethod.POST, params = "update" )
	public ModelAndView update(Product product)
	{
		Optional<Product> temp = pr.findById(product.getId());
		Product p=null;
		if(temp.isPresent())
		{
			p=product;
			pr.save(p);
		}
		return home();
	}
	
	@RequestMapping(value = "/btn", method = RequestMethod.POST, params = "delete" )
	public ModelAndView delete(Product product)
	{
		Optional<Product> temp = pr.findById(product.getId());
		Product p=null;
		if(temp.isPresent())
		{
			p=temp.get();
			pr.delete(p);
		}
		return home();
	}
	
	@GetMapping("/select")
	public ModelAndView select(@RequestParam("id")Integer id)
	{
		Optional<Product> temp = pr.findById(id);
		Product product=new Product();
		ModelAndView mv=new ModelAndView();
		if(temp.isPresent())
		{
			product=temp.get();
			List<Product> products = pr.findAll();

			mv.setViewName("index");
			mv.addObject("product", product);
			mv.addObject("products", products);
			
		}
		return mv;			
		
	}
	
	@GetMapping("/showUpload")
	public ModelAndView upload(@RequestParam("id")Integer id, HttpSession session)
	{
		Optional<Product> temp = pr.findById(id);
		Product product=new Product();
		ModelAndView mv=new ModelAndView();
		session.setAttribute("id", id);
		if(temp.isPresent())
		{
			product=temp.get();
			List<Product> products = pr.findAll();

			mv.setViewName("upload");
			mv.addObject("product", product);
			mv.addObject("products", products);
			
		}
		return mv;	
	}
	
	@PostMapping("/upload")
	public ModelAndView upload(@RequestParam("id") Integer id, @RequestParam("pic") MultipartFile file) throws IOException
	{
		Optional<Product> temp = pr.findById(id);
		Product product=new Product();
		ModelAndView mv=new ModelAndView();
		if(temp.isPresent())
		{
			product=temp.get();
			/*
			 * update happens here
			 */
			product.setPic(file.getBytes());
			pr.save(product);
			List<Product> products = pr.findAll();

			mv.setViewName("index");
			mv.addObject("product", product);
			mv.addObject("products", products);
			
		}
		return mv;	
	}
}
