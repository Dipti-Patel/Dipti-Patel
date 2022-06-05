package com.dp.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.dp.store.model.Devices;

@Controller
public class StoreController {

	private ModelAndView modelAndView;
	private Devices result;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String getLink() {
		return "firstPage";
	}

	@RequestMapping("/{brandName}")
	public ModelAndView samsung(@PathVariable("brandName") String brandName) {
		String editedBrandName = brandName.toLowerCase();
		System.out.println("BRAND NAME :::" + editedBrandName);
		modelAndView = new ModelAndView("viewDevices");
		if (editedBrandName.equals("samsung")) {

			result = restTemplate.getForObject("http://localhost:8082/samsung/devices", Devices.class);
//			result = restTemplate.getForObject("http://SAMSUNG/samsung/devices", Devices.class);
			System.out.println("result" + result.getDevices().get(0).getName());
			modelAndView.addObject("devices", result);

			return modelAndView;
		} else if (editedBrandName.equals("apple")) {

			result = restTemplate.getForObject("http://localhost:8083/apple/devices", Devices.class);
			modelAndView.addObject("devices", result);

			return modelAndView;
		} else {
			return new ModelAndView("redirect:/error");
		}
	}

}
