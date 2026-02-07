package com.jobfinder.job_finder.entity;

import jakarta.persistence.*;
import lombok.*;
import com.jobfinder.job_finder.entity.Job;
import com.jobfinder.job_finder.service.JobApplicationService;
import com.jobfinder.job_finder.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;
    private String location;

    @Column(length = 2000)
    private String description;
}
