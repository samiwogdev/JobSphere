package samiwogDev.example.JobSphere.job.impl;

import org.springframework.stereotype.Service;
import samiwogDev.example.JobSphere.job.Job;
import samiwogDev.example.JobSphere.job.JobRepository;
import samiwogDev.example.JobSphere.job.JobService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    //private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;
    private Long nextId = 1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

//    public List<Job> findAll(){
//        if (jobs.isEmpty())
//            return null;
//            return jobs;
//    }

    public List<Job> findAll(){
        return jobRepository.findAll();
    }

//    public void createJob(Job job){
//        job.setId(nextId++);
//        jobs.add(job);
//    }

    public void createJob(Job job){
        job.setId(nextId++);
        jobRepository.save(job);
    }

//    @Override
//    public Job getJobById(Long id) {
//       for (Job job: jobs){
//           if(job.getId().equals(id)) {
//               return job;
//           }
//       }
//        return null;
//    }

    @Override
    public Job getJobById(Long id) {
       return jobRepository.findById(id).orElse(null);
    }

//    @Override
//    public boolean deleteJobById(Long id){
//        Iterator<Job> iterator = jobs.iterator();
//    while(iterator.hasNext()){
//        Job job = iterator.next();
//        if (job.getId().equals(id)){
//            iterator.remove();
//            return true;
//        }
//    }
//        return false;
//    }

    @Override
    public boolean deleteJobById(Long id){
        try {
            jobRepository.deleteById(id);
            return true;
        } catch(Exception e){
         return false;
        }
    }

//    @Override
//    public boolean updateJob(Long id, Job updatedJob) {
//        for(Job job : jobs){
//            if(job.getId().equals(id)){
//                job.setTitle(updatedJob.getTitle());
//                job.setDescription(updatedJob.getDescription());
//                job.setLocation(updatedJob.getLocation());
//                job.setMinSalary(updatedJob.getMinSalary());
//                job.setMaxSalary(updatedJob.getMaxSalary());
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
            if(jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                jobRepository.save(job);
                return true;
            }
        return false;
    }


}
