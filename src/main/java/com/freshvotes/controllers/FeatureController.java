package com.freshvotes.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freshvotes.domain.Feature;
import com.freshvotes.service.FeatureService;

@Controller
@RequestMapping("/products/{productId}/features")
public class FeatureController {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private FeatureService featureService;

	
	@PostMapping("")
	public String createFeature(@PathVariable Long productId) {
		
		Feature feature = featureService.createFeature(productId);
		
		return "redirect:/products/"+productId+"/features/"+feature.getId();	
		}

	@GetMapping("/{featureId}")
	public String getFeature(ModelMap model, @PathVariable Long productId, @PathVariable Long featureId) {
		Optional<Feature> featureOpt =  featureService.findById(featureId);
		if(featureOpt.isPresent()) {
			model.put("feature", featureOpt.get());
		}
		// TODO handle the situation where feature not exist
		
		return "feature";
		
	}
	
	@PostMapping("{featureId}")
	public String updateFeature(Feature feature, @PathVariable Long productId, @PathVariable Long featureId) {
		 feature = featureService.save(feature);
		
		try {
			String encodedProductName = URLEncoder.encode(feature.getProduct().getName(), "UTF-8");
			return "redirect:/p/" + encodedProductName;
		} catch (UnsupportedEncodingException e) {
			log.debug("error in encoding product name" + feature.getProduct().getName());
			return "redirect:/dashboard/";
		}
		 
		
		
	}

}
