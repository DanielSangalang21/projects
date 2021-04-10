package dcs.rentalApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import dcs.rentalApp.ObjectFactory;
import dcs.rentalApp.bean.SoundEquipmentBean;
import dcs.rentalApp.implem.SoundEquipmentImplem;


@RestController
@RequestMapping("login")
@SessionAttributes("daniel")
public class loginController {

	//@Autowired
	SoundEquipmentImplem soundEquipmentImplem = (SoundEquipmentImplem) ObjectFactory.getObject("soundEquipmentImplem");
	
	@RequestMapping(method = RequestMethod.GET)
	public String formBackingObject(HttpServletRequest request, ModelMap model) {
		@SuppressWarnings("unchecked")
		List<SoundEquipmentBean> daniel = (List<SoundEquipmentBean>) soundEquipmentImplem.getEquipments();
		model.addAttribute("daniel",daniel);
		request.setAttribute("implem", soundEquipmentImplem);
		return "login";
	}
}
