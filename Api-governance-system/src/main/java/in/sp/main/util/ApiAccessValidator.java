package in.sp.main.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.sp.main.exception.CustomException;
import in.sp.main.repository.AccessRequestRepository;

@Component
public class ApiAccessValidator {

    @Autowired
    private AccessRequestRepository accessRepo;

    public void validate(Long userId, Long apiId) {

        accessRepo.findAll()
            .stream()
            .filter(r -> r.getUserId().equals(userId)
                    && r.getApiId().equals(apiId)
                    && r.getStatus().equals("APPROVED"))
            .findFirst()
            .orElseThrow(() -> new CustomException("API Access Not Approved"));
    }
}