package com.jobfinder.job_finder.service;

import com.jobfinder.job_finder.entity.Job;
import com.jobfinder.job_finder.entity.JobApplication;
import com.jobfinder.job_finder.entity.JobApplicationStatus;
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

    // Apply for a job (prevents duplicate applications)
    public void applyForJob(Long jobId, String applicantEmail) {
        if (jobApplicationRepository.existsByJobIdAndApplicantEmail(jobId, applicantEmail)) {
            return; // already applied
        }

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        JobApplication application = new JobApplication();
        application.setJob(job);
        application.setApplicantEmail(applicantEmail);
        application.setStatus(JobApplicationStatus.APPLIED);


        jobApplicationRepository.save(application);
    }

    // Job seeker: view own applications
    public List<JobApplication> getApplicationsForUser(String email) {
        return jobApplicationRepository.findByApplicantEmail(email);
    }

    // Employer: view applications per job
    public List<JobApplication> getApplicationsByJobId(Long jobId) {
        return jobApplicationRepository.findByJobId(jobId);
    }
}
