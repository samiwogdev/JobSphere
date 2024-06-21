package samiwogDev.example.JobSphere.job.impl;

import org.springframework.stereotype.Service;
import samiwogDev.example.JobSphere.job.Job;
import samiwogDev.example.JobSphere.job.JobService;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    public List<Job> findAll(){
        return jobs;
    }

    public void creatJob(Job job){
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        return null;
    }
}
