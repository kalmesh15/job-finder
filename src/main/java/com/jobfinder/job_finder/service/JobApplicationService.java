package com.jobfinder.job_finder.service;

import com.jobfinder.job_finder.entity.Job;
import com.jobfinder.job_finder.entity.JobApplication;
import com.jobfinder.job_finder.repository.JobApplicationRepository;
import com.jobfinder.job_finder.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobRepository jobRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository,
                                 JobRepository jobRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.jobRepository = jobRepository;
    }

    // ================= APPLY =================
    public void apply(Long jobId, String email) {

        if (jobApplicationRepository.existsByJobIdAndApplicantEmail(jobId, email)) {
            return;
        }

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        JobApplication application = new JobApplication();
        application.setJob(job);
        application.setApplicantEmail(email);
        application.setStatus("APPLIED");

        jobApplicationRepository.save(application);
    }

    // ================= JOBSEEKER =================
    public List<JobApplication> getApplicationsForUser(String email) {
        return jobApplicationRepository.findByApplicantEmail(email);
    }

    // ================= EMPLOYER =================
    public List<JobApplication> getApplicationsByJobId(Long jobId) {
        return jobApplicationRepository.findByJobId(jobId);
    }
}
