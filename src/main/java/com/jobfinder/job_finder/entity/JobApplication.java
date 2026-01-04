package com.jobfinder.job_finder.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "job_applications")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private String applicantEmail;

    @Enumerated(EnumType.STRING)
    private JobApplicationStatus status;

    // getters & setters
    public void setJob(Job job) {
        this.job = job;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public void setStatus(JobApplicationStatus status) {
        this.status = status;
    }
}
