package com.jobfinder.job_finder.controller;

import com.jobfinder.job_finder.entity.Job;
import com.jobfinder.job_finder.service.JobApplicationService;
import com.jobfinder.job_finder.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    private final JobService jobService;
    private final JobApplicationService jobApplicationService;

    public EmployerController(JobService jobService,
                              JobApplicationService jobApplicationService) {
        this.jobService = jobService;
        this.jobApplicationService = jobApplicationService;
    }

    // ================= DASHBOARD =================
    @GetMapping("/dashboard")
    public String dashboard() {
        return "employer-dashboard";
    }

    // ================= VIEW JOBS =================
    @GetMapping("/jobs")
    public String viewJobs(Model model) {
        model.addAttribute("jobs", jobService.getAllJobs());
        return "employer-jobs";
    }

    // ================= POST JOB =================
    @GetMapping("/post-job")
    public String postJobForm(Model model) {
        model.addAttribute("job", new Job());
        return "post-job";
    }

    @PostMapping("/post-job")
    public String saveJob(Job job) {
        jobService.saveJob(job);
        return "redirect:/employer/jobs";
    }

    // ================= VIEW APPLICATIONS =================
    @GetMapping("/job/{jobId}/applications")
    public String viewApplications(@PathVariable Long jobId, Model model) {
        model.addAttribute(
                "applications",
                jobApplicationService.getApplicationsByJobId(jobId)
        );
        return "employer-applicants";
    }
}
