package com.jobfinder.job_finder.service;

import com.jobfinder.job_finder.entity.Job;
import com.jobfinder.job_finder.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // ================= SAVE JOB =================
    public void saveJob(Job job) {
        jobRepository.save(job);
    }

    // ================= ALL JOBS =================
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // ================= SEARCH JOBS =================
    public List<Job> searchJobs(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllJobs();
        }
        return jobRepository
                .findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCase(
                        keyword, keyword
                );
    }

}
