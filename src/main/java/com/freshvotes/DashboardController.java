package com.freshvotes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DashboardController
{
	@GetMapping(value = "/")
	public String homePage() 
	{
		return "index";
	}
}
