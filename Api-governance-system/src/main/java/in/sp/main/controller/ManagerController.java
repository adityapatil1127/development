package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.service.GovernanceService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private GovernanceService service;
	
	
	@PutMapping("/review/{requestId}")
	public String review(@PathVariable Long requestId) {
		service.reviewRequest(requestId);
		return "Access Reviewed by Manager";
	}
	
}
