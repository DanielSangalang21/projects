	package dcs.rentalApp.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
//import com.sun.java.util.jar.pack.Package.File;

import dcs.rentalApp.ObjectFactory;
import dcs.rentalApp.bean.SoundEquipmentBean;
import dcs.rentalApp.implem.SoundEquipmentImplem;

@RestController
@RequestMapping("equipment")
@SessionAttributes("soundEquipmentBean")
@CrossOrigin
public class SoundEquipmentController {

	SoundEquipmentImplem soundEquipmentImplem = (SoundEquipmentImplem) ObjectFactory.getObject("soundEquipmentImplem");
	
	@RequestMapping(method = RequestMethod.GET)
	public String formBackingObject(HttpServletRequest request, ModelMap modelMap) throws JsonProcessingException, CloneNotSupportedException {
		SoundEquipmentBean equipment = (SoundEquipmentBean) soundEquipmentImplem.getEquipment();
		//return JSONMapper.map(equipment);
		modelMap.addAttribute("soundEquipmentBean", equipment);
		return "soundEquipment";
		//model.addAttribute("equipment",equipment);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addEquipment(@RequestParam("pictureFile") MultipartFile file
			,@ModelAttribute("soundEquipmentBean") SoundEquipmentBean sbean
			,HttpServletRequest request,HttpServletResponse response
			, ModelMap modelMap) throws IllegalStateException, IOException{
		String uploadsDir = "/WEB-INF/uploads/";
		String uploadpath = request.getSession().getServletContext().getRealPath(uploadsDir);
		String newFilePath = uploadpath + file.getOriginalFilename();
		File f = new File(newFilePath);
		file.transferTo(f);
		modelMap.addAttribute("fileUploadedPath",newFilePath);
		return "soundEquipment";
	}
}
