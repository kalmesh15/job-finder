package com.jobfinder.job_finder.controller;

import com.jobfinder.job_finder.entity.Job;
import com.jobfinder.job_finder.service.JobApplicationService;
import com.jobfinder.job_finder.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    // ===================== DASHBOARD =====================
    @GetMapping("/dashboard")
    public String employerDashboard() {
        return "employer-dashboard";
    }

    // ===================== VIEW JOBS =====================
    @GetMapping("/jobs")
    public String viewJobs(Model model) {
        model.addAttribute("jobs", jobService.getAllJobs());
        return "employer-jobs";
    }

    // ===================== POST JOB PAGE =====================
    @GetMapping("/post-job")
    public String postJobForm(Model model) {
        model.addAttribute("job", new Job());
        return "post-job";
    }

    // ===================== SAVE JOB =====================
    @PostMapping("/post-job")
    public String saveJob(Job job) {
        jobService.saveJob(job);
        return "redirect:/employer/jobs";
    }

    // ===================== VIEW APPLICATIONS =====================
    @GetMapping("/jobs/{id}/applications")
    public String viewApplications(@PathVariable Long id, Model model) {
        model.addAttribute(
                "applications",
                jobApplicationService.getApplicationsByJobId(id)
        );
        return "jobseeker-applications";
    }
}
