package samiwogDev.example.JobSphere.job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    void creatJob(Job job);

    Job getJobById(Long id);
}
