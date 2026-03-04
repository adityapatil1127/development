package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entity.ApiResource;
import in.sp.main.repository.ApiResourceRepository;

@RestController
@RequestMapping("/admin/api")
public class ApiResourceController {

    @Autowired
    private ApiResourceRepository repo;

    @PostMapping("/create")
    public ApiResource createApi(@RequestBody ApiResource api) {
        return repo.save(api);
    }

    @GetMapping("/all")
    public Iterable<ApiResource> getAll() {
        return repo.findAll();
    }
}