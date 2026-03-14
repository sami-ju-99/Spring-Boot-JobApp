package com.example.SpringBootWeb;

import com.example.SpringBootWeb.JobPost;
import com.example.SpringBootWeb.JobRepo;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private JobService service;

    @RequestMapping({"/", "home"})
    public String home()
    {
        System.out.println("home method called");
        return "index";
    }

    @RequestMapping({"/addjob", "/addJob"})
    public String addJob()
    {
        System.out.println("addjob method called");
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost) {
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("/viewalljobs")
    public String viewJobs(Model m) {
        System.out.println("viewjobs called");
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts", jobs);

        return "viewalljobs";
    }

}
