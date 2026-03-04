package in.sp.main.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entity.AccessRequest;
import in.sp.main.entity.RequestStatus;
import in.sp.main.repository.AccessRequestRepository;

@Service
public class GovernanceService {

    @Autowired
    private AccessRequestRepository accessRepo;

    // STEP 1 - developer requests access
    public void requestAccess(Long userId, Long apiId) {
    boolean alreadyExists=	accessRepo.existsByUserIdAndApiId(userId, apiId);
    	 if(alreadyExists) {
    	        throw new RuntimeException("Access already requested for this API");
    	    }
    	 
        AccessRequest req = new AccessRequest();
        req.setUserId(userId);
        req.setApiId(apiId);
        req.setStatus(RequestStatus.PENDING);
        accessRepo.save(req);
    }

    // STEP 2 - managerr reviews
    public void reviewRequest(Long requestId) {
        AccessRequest req = accessRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request Not Found"));
  
        req.setStatus(RequestStatus.REVIEWED);
        accessRepo.save(req);
    }

    // STEP 3 - admin approves
    public void approveRequest(Long requestId) {
        AccessRequest req = accessRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request Not Found"));

        if (req.getStatus() != RequestStatus.REVIEWED) {
            throw new RuntimeException("Manager Review Required Before Approval");
        }

        req.setStatus(RequestStatus.APPROVED);
        req.setExpiryDate(LocalDate.now().plusDays(7)); // 7 day

        accessRepo.save(req);
    }

    // STEP 4 - admin rejects
    public void rejectRequest(Long requestId) {

        AccessRequest req = accessRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request Not Found"));

        req.setStatus(RequestStatus.REJECTED);
        accessRepo.save(req);
    }
//delete by  id
    public void deleteById(Long requestId) {
        accessRepo.deleteById(requestId);
    }

    
    //delete  multiple by id
    public void deleteMultiple(List<Long> ids) {
        accessRepo.deleteAllById(ids);
    }
}