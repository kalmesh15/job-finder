package com.jobfinder.job_finder.controller;

import com.jobfinder.job_finder.service.JobApplicationService;
import com.jobfinder.job_finder.service.JobService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobseeker")
public class JobSeekerController {

    private final JobService jobService;
    private final JobApplicationService jobApplicationService;

    public JobSeekerController(
            JobService jobService,
            JobApplicationService jobApplicationService
    ) {
        this.jobService = jobService;
        this.jobApplicationService = jobApplicationService;
    }

    // ===================== DASHBOARD =====================
    @GetMapping("/dashboard")
    public String dashboard() {
        return "jobseeker-dashboard";
    }

    // ===================== VIEW JOBS =====================
    @GetMapping("/jobs")
    public String viewJobs(Model model) {
        model.addAttribute("jobs", jobService.getAllJobs());
        return "jobseeker-jobs";
    }

    // ===================== APPLY JOB =====================
    @PostMapping("/apply/{jobId}")
    public String applyJob(
            @PathVariable Long jobId,
            Authentication authentication
    ) {
        jobApplicationService.apply(jobId, authentication.getName());
        return "redirect:/jobseeker/jobs";
    }

    // ===================== MY APPLICATIONS =====================
    @GetMapping("/applications")
    public String myApplications(
            Model model,
            Authentication authentication
    ) {
        model.addAttribute(
                "applications",
                jobApplicationService.getApplicationsForUser(authentication.getName())
        );
        return "jobseeker-applications";
    }
}
