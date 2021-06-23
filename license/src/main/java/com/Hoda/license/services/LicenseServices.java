package com.Hoda.license.services;

import org.springframework.stereotype.Service;

import com.Hoda.license.models.License;
import com.Hoda.license.repository.LicenseRepository;
import java.util.List;

@Service
public class LicenseServices {
	private final LicenseRepository licenseRepository;

	public  LicenseServices(LicenseRepository licenseRepository) {
		this.licenseRepository =licenseRepository;
	}
	public List<License> allicense() {
	    return licenseRepository.findAll();
	}
	public License createlicnse(License b) {
		return licenseRepository.save(b);
	}
	
}
