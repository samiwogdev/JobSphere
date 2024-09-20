package samiwogDev.example.JobSphere.company.impl;

import org.springframework.stereotype.Service;
import samiwogDev.example.JobSphere.company.Company;
import samiwogDev.example.JobSphere.company.CompanyRepository;
import samiwogDev.example.JobSphere.company.CompanyService;
import samiwogDev.example.JobSphere.job.Job;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl  implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Boolean updateCompany(Company updatedCompany, Long Id) {
        Optional<Company> oldCompanyData = companyRepository.findById(Id);
        if(oldCompanyData.isPresent()){
            Company companyInstance = oldCompanyData.get();
            companyInstance.setName(updatedCompany.getName());
            companyInstance.setJobs(updatedCompany.getJobs());
            companyInstance.setDescription(updatedCompany.getDescription());
            companyRepository.save(companyInstance);
            return true;
        }
        return false;
    }
}
