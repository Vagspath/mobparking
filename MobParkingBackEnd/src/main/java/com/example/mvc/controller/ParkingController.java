package com.example.mvc.controller;


import java.util.Date;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.mvc.entity.Parking;

import com.example.mvc.service.ParkingService;


@Controller
@RequestMapping("/parking")
public class ParkingController {
    protected static final int DEFAULT_PAGE_NUM = 0;
    protected static final int DEFAULT_PAGE_SIZE = 25;
    private Model model;
    @Inject
    protected ParkingService parkingService;

    protected static final Logger LOGGER = LoggerFactory
            .getLogger(ParkingController.class);

    
    @RequestMapping(value = "/list")
    public String list(
            @RequestParam(value = "page", required = false) Integer page,
            Model model) {
        int pageNum = page != null ? page : DEFAULT_PAGE_NUM;
        Page<Parking> paging = parkingService.findAll(pageNum, DEFAULT_PAGE_SIZE);
        model.addAttribute("page", paging);
        this.model = model;
        return "/parking/list";
    }


    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public @ModelAttribute
    Parking create(Model model) {
    	Parking Parking = new Parking();
        return Parking;
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String createOnSubmit(@Valid Parking parking ,
            BindingResult bindingResult, Model model) {
        LOGGER.debug("create Parking={}", parking);
        parking.setTimeOfEntrance(new Date());
   
        if (bindingResult.hasErrors()) {
            LOGGER.warn("validation error={}", bindingResult.getModel());
            model.addAllAttributes(bindingResult.getModel());
            return "/parking/form";
        }
        parkingService.insert(parking);
        return "redirect:/parking/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model) {
    	Parking Parking = parkingService.findByCode(id);
        model.addAttribute(Parking);
        return "/parking/form";
    }
    @RequestMapping(value = "/complete/{id}", method = RequestMethod.GET)
    public String complete(@PathVariable("id") Long id, Model model) {
    	Parking parking = parkingService.findByCode(id);
       
       parking.setTimeOfExit(new Date());
        parking.setPayed(true);
        parkingService.update(parking);
        return "redirect:/parking/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editOnSubmit(@Valid Parking parking,
            BindingResult bindingResult, Model model) {
        LOGGER.debug("edit Parking={}", parking);
        if (bindingResult.hasErrors()) {
            LOGGER.warn("validation error={}", bindingResult.getModel());
            model.addAllAttributes(bindingResult.getModel());
            model.addAttribute("timeOfEntrance", new Date());
            return "/parking/form";
        }
        parkingService.update(parking);
        return "redirect:/parking/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(
            @RequestParam(value = "page", required = false) Integer page,
            @PathVariable("id") Long id) {
        LOGGER.debug("delete id={}", id);
        parkingService.deleteByCode(id);

        return "redirect:/parking/list";
    }
    
    
    public void throwException(){
    	try{
    	throw new RefreshException();
    	}
    	catch(RefreshException e){
    		e.callList();
    	}
    }
    
  public  class RefreshException extends  RuntimeException {
   	  public RefreshException() { super();
   	  callList(); }
   	  
   	  public void callList(){
   		list(1,model);
   	  }


}

	 
	}
