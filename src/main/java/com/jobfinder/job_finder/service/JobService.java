package com.jobfinder.job_finder.service;

import com.jobfinder.job_finder.entity.Job;
import com.jobfinder.job_finder.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // ✅ Save job (USED BY EMPLOYER)
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    // ✅ Get all jobs (USED BY JOB SEEKER)
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // ✅ Get job by ID (USED FOR APPLY)
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    // Optional (future use)
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
