package com.jobfinder.job_finder.repository;

import com.jobfinder.job_finder.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {

    boolean existsByJobIdAndApplicantEmail(Long jobId, String applicantEmail);

    List<JobApplication> findByApplicantEmail(String applicantEmail);

    List<JobApplication> findByJobId(Long jobId);
}
