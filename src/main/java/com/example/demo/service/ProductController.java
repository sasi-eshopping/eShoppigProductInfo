package com.example.demo.service;




import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@Controller    // This means that this class is a Controller
@RequestMapping(path="/products") // This means URL's start with /demo (after Application path)
public class ProductController {

    Logger logger=LoggerFactory.getLogger(ProductController.class);
	@GetMapping(path="/getProduct/{id}")
	public @ResponseBody Product  getProduct(@PathVariable("id") String id) throws Exception {
		logger.trace("Error happaned");
	if(id.equalsIgnoreCase("1"))
	{
		Thread.sleep(500);
		System.out.println("500");
	}
	else if(id.equalsIgnoreCase("2"))
	{
		Thread.sleep(1000);
		System.out.println("1000");
	}
	else if(id.equalsIgnoreCase("3"))
	{
		Thread.sleep(2000);
		System.out.println("2000");
	}
	else
	{
	Thread.sleep(4000);
	System.out.println("4000");
	}
	//Product prod=new Product("1","Pen","12");
	return  new Product("1","Pen","12");
	
	}


}