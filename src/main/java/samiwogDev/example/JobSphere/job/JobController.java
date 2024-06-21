package samiwogDev.example.JobSphere.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private JobService jobservice;

    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobservice.findAll();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
        jobservice.creatJob(job);
        return "Job Added Successfully";
    }

    public Job getJobById(@PathVariable Long id){
        Job job = jobservice.getJobById(id);
        return job;
    }
}
