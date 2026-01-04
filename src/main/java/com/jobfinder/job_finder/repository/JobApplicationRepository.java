package com.jobfinder.job_finder.repository;

import com.jobfinder.job_finder.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {

    // JobSeeker – My Applications
    List<JobApplication> findByApplicantEmail(String applicantEmail);

    // Employer – View applications for a specific job
    List<JobApplication> findByJobId(Long jobId);

    // Prevent duplicate applications
    boolean existsByJobIdAndApplicantEmail(Long jobId, String applicantEmail);
}
