package com.start.controller;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.start.dao.PatientRepository;
import com.start.entities.Patient;


@Controller
public class HomeController {

	@Autowired
	private PatientRepository p;
	
	@GetMapping("/")
	public String home(Model m)
	{
		
		m.addAttribute("patient", new Patient());
		return "home";
	}
	
	 @RequestMapping(path = "/delete/{id}")
	    public String deleteEmployeeById(Model model, @PathVariable("id") int id)
	    {
	        p.deleteById(id);
	        return "redirect:/";
	    }
	 

	  @RequestMapping("/edit/{id}")
		public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
			ModelAndView mav = new ModelAndView("edit_product");
			Patient patient = p.findById(id).get();
			p.delete(patient);
			mav.addObject("patient", patient);
			
			return mav;
		}
	 
	@PostMapping("/save_data")
	public String registeruser(@ModelAttribute("patient") Patient patient) {
		
		
		p.save(patient);
	
		return "redirect:/";
	}
	
	@GetMapping("/show_data")
	String show(Model m) {
		List<Patient> images = p.findAll();
		m.addAttribute("images", images);
		return "show";
	}
	
}
