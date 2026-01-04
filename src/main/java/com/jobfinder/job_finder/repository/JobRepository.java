package com.jobfinder.job_finder.repository;

import com.jobfinder.job_finder.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
