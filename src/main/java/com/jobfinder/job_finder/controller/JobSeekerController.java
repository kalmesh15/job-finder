package com.jobfinder.job_finder.controller;

import com.jobfinder.job_finder.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobseeker")
public class JobSeekerController {

    private final JobService jobService;

    public JobSeekerController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public String viewJobs(Model model) {
        model.addAttribute("jobs", jobService.getAllJobs());
        return "jobseeker-jobs";
    }
}
