package in.sp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.service.GovernanceService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private GovernanceService service;

	@PutMapping("/approve/{requestId}")
 public String approve(@PathVariable Long requestId) {
	 service.approveRequest(requestId);
	 return "Access Approved By Admin";
 }
	@PutMapping("/reject/{requestId}")
	public String reject(@PathVariable Long requestId) {
		service.rejectRequest(requestId);
		return "Access Rejected By Admin";
	}
	
	@DeleteMapping("/delete/{requestId}")
	public String deleteById(@PathVariable Long requestId) {
		service.deleteById(requestId);
		return "Access Request Deleted";
				
	}
	
 @DeleteMapping("/delete/multiple")
 public String deleteMultiple(@RequestBody List<Long> ids) {
	return "Multiple request deleted";
}
}
