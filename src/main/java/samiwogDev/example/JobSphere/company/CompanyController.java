package samiwogDev.example.JobSphere.company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
 @RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
@GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    public ResponseEntity<String> updateCompany(@PathVariable Long Id, @RequestBody Company company){

    }
}
