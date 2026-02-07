package com.jobfinder.job_finder.repository;

import com.jobfinder.job_finder.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    // Search by title or company
    List<Job> findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCase(
            String title,
            String company
    );

}
