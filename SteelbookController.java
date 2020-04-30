package com.steelbooks.crudapp.controller;

import java.text.Normalizer.Form;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.steelbooks.crudapp.entity.Steelbook;
import com.steelbooks.crudapp.repository.SteelbookRepository;

@Controller
//@RequestMapping("/steelbooks")
@RequestMapping("/")
public class SteelbookController {

	@Autowired
	private SteelbookRepository steelbookService;
	
	
	/*@Value("${msg.title}")
	private String title;
	 
	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
	    model.addAttribute("title", title);
	    return "index";
	}*/
	
	//add new steelbook form
	@GetMapping("showForm")
	public String showSteelbookForm(Steelbook steelbook) {
		return "add-steelbook";
	}
	
	///original way to list the movies***
	//list of steelbook movies
/*	@GetMapping("list")
	public String steelbooks(Model model) {
		model.addAttribute("steelbooks", this.steelbookRepository.findAll());
		return "index";
	}*/
	
	//list of steelbook movies
	/*  @GetMapping("list")
	    public String steelbooks(Model model) {
	        model.addAttribute("steelbooks", steelbookService.findAll());
	        return "index";
	    }*/
	  
	  
	/*  @GetMapping("list")
	    public ModelAndView listSteelbooksPageByPage(@PathVariable("page") int page) {
	        ModelAndView modelAndView = new ModelAndView("steelbook-list-paging");
	        PageRequest pageable = PageRequest.of(page - 1, 15);
	        Page<Steelbook> steelbookPage = steelbookService.getPaginatedSteelbooks(pageable);
	        int totalPages = steelbookPage.getTotalPages();
	        if(totalPages > 0) {
	            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
	            modelAndView.addObject("pageNumbers", pageNumbers);
	        }
	        modelAndView.addObject("activeArticleList", true);
	        modelAndView.addObject("articleList", steelbookPage.getContent());
	        return modelAndView;
	    }*/
	
	@GetMapping("steelbooks")
	//  @GetMapping("list")
	    public String steelbooks(HttpServletRequest request, Model model) {
	        
	        int page = 0; //default page number is 0 
	        int size = 10; //default page size is 10
	        
	        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
	            page = Integer.parseInt(request.getParameter("page")) - 1;
	        }

	        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
	            size = Integer.parseInt(request.getParameter("size"));
	        }
	        
	        model.addAttribute("steelbooks", steelbookService.findAll(PageRequest.of(page, size)));
	        //return "index";
	        return "list-steelbook";
	    }
	  
	
	@PostMapping("add")
	public String addSteelbooks(@Valid Steelbook steelbook, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-steelbook";
		}
		
		this.steelbookService.save(steelbook);
		//return "redirect:list";
		return "redirect:steelbooks";
	}
	
	//edit steelbook form
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable ("id") long id, Model model) {
		Steelbook steelbook = this.steelbookService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid steelbook id : " + id));
		
		model.addAttribute("steelbook", steelbook);
		return "update-steelbook";
	}
	
	@PostMapping("update/{id}")
	public String updateSteelbook(@PathVariable("id") long id, @Valid Steelbook steelbook, BindingResult result, Model model) {
		if(result.hasErrors()) {
			steelbook.setId(id);
			return "update-steelbook";
		}
		
		// update steelbook
		this.steelbookService.save(steelbook);
		
		// get all steelbooks ( with update)
		model.addAttribute("steelbooks", this.steelbookService.findAll());
		//return "index";
		//return "list-steelbooks";
		
		

	    return "redirect:/steelbooks";

	}
	
	@GetMapping("delete/{id}")
	public String deleteSteelbook(@PathVariable ("id") long id, Model model) {
		
		Steelbook steelbook = this.steelbookService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid steelbook id : " + id));
		
		this.steelbookService.delete(steelbook);
		model.addAttribute("steelbooks", this.steelbookService.findAll());
		//return "redirect:list";
		return "redirect:/steelbooks";

	}
	
	@GetMapping("details/{id}")
	//  @GetMapping("list")
	public String showDetails(@PathVariable ("id") long id, Model model) {
		Steelbook steelbook = this.steelbookService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid steelbook id : " + id));
		
		model.addAttribute("steelbook", steelbook);
		return "steelbook-details";
	}
}

