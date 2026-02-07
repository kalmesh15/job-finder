package com.jobfinder.job_finder.repository;

import com.jobfinder.job_finder.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {

    // JobSeeker – My Applications
    List<JobApplication> findByApplicantEmail(String applicantEmail);

    // Employer – View applications for a job
    List<JobApplication> findByJobId(Long jobId);

    // Prevent duplicate apply
    boolean existsByJobIdAndApplicantEmail(Long jobId, String applicantEmail);
}
