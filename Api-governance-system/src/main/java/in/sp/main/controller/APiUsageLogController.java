package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.sp.main.entity.ApiUsageLog;
import in.sp.main.repository.ApiUsageLogRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/usage")
public class APiUsageLogController {

    @Autowired
    private ApiUsageLogRepository repo;

    // Log API Usage
    @PostMapping("/log")
    public String logUsage(@RequestBody ApiUsageLog log){

        log.setUserAt(LocalDate.now());
        repo.save(log);
 
        return "API Usage Logged";
    }

    // View All Usage Logs
    @GetMapping("/all")
    public List<ApiUsageLog> getAllLogs(){
        return repo.findAll();
    }
}