package com.dp.apple.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dp.apple.model.Device;
import com.dp.apple.model.Devices;

@RestController
@RequestMapping("/apple")
public class AppleController {
	
	@RequestMapping("/devices")
	public Devices getDevices() {
		
		List<Device> devices = new ArrayList<>();
		devices.add(new Device("Ipad 2019","Tablet"));
		devices.add(new Device("Iphone X","Smartphone"));
		
		Devices devicesList = new Devices(devices);
        return  devicesList;
	}
        
}
