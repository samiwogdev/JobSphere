package samiwogDev.example.JobSphere.company;

import java.util.List;


public interface CompanyService {
List<Company> getAllCompanies();
Boolean updateCompany(Company company, Long Id);
}
