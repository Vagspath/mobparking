package com.example.mvc.controller;

import java.applet.AudioClip;
import java.awt.Toolkit;
import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


import com.example.mvc.entity.Parking;

import com.example.mvc.service.ParkingService;
import com.mvc.utils.SpringMVCUtils;

/**
 * In this class we implement Rest API
 * 
 * With URL ../api/topup?auth=".." POST method {...} topup in JSON type we send a topup
 * 
 * with URL ../api/topups GET we get the list of topups from database
 */

@Controller
@Resource(name = "restController")
@RequestMapping("/api")
public class ParkingRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingRestController.class);

	@Resource(name = "ParkingService")
	private ParkingService parkingService;
	
	@Resource(name = "parkingController")
	private ParkingController parkingController;


	@RequestMapping(value = "/parking", method = RequestMethod.POST, headers = "Accept=application/xml,application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> addJsonTopUp(	@RequestBody
	Parking Parking) {
		
		Date date = new Date();
		try {
			parkingService.insert(Parking);
			//Toolkit.getDefaultToolkit().beep();
			playSound();
           
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("\"success\":\"The request has been successfully received  and is queued  for processing.\"",
				HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/myList", method = RequestMethod.GET, headers = "Accept=application/xml,application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody  ModelAndView list(org.springframework.ui.Model model) {
		
		List<Parking> topups = this.parkingService.findAll();
		return SpringMVCUtils.getOutputModel(topups);
	}
	
	   
	  @RequestMapping(value = "/{id}",
				method = RequestMethod.GET,
				headers="Accept=application/xml,application/json")
		@ResponseStatus(HttpStatus.OK)
	public ModelAndView  getPersom(@PathVariable("id") int id) {


return SpringMVCUtils.getOutputModel(parkingService.findByCode((long)id));
    }

	public void playSound(){
	     try {
	            System.out.println("Start");
	            File f = new File("c://wavs//beep.wav");
	            AudioInputStream audio = AudioSystem.getAudioInputStream(f);
	            AudioFormat format;
	            format = audio.getFormat();
	            SourceDataLine auline;
	            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
	            auline = (SourceDataLine) AudioSystem.getLine(info);
	            auline.open(format);
	            auline.start();
	            int nBytesRead = 0;
	            byte[] abData = new byte[524288];
	            while (nBytesRead != -1) {
	                nBytesRead = audio.read(abData, 0, abData.length);
	                if (nBytesRead >= 0) {
	                    auline.write(abData, 0, nBytesRead);
	                }
	            }
	        } catch (Exception E) {
	            System.out.println(E.getMessage());

	        }
	}
	
}
