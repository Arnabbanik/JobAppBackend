package com.arnabapp.JobApp.controller;

import com.arnabapp.JobApp.model.JobPost;
import com.arnabapp.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS},
        allowedHeaders = "*",
        allowCredentials = "true")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }


    @PostMapping("jobPost")
    public ResponseEntity<?> addJob(@RequestPart JobPost jobPost, @RequestPart MultipartFile image) throws IOException {
        try {
            JobPost savedJobPost = jobService.addJob(jobPost, image);
            return new ResponseEntity<>(savedJobPost, HttpStatus.CREATED);
        }catch(IOException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("jobPost/{postId}")//pathvariable example
    public JobPost getJobById(@PathVariable String postId){
        return jobService.getJobById(postId);
    }

    @PutMapping("updateJobPost")
    public JobPost updateJob(@RequestPart JobPost jobPost, @RequestPart MultipartFile image) throws IOException {
         jobService.updateJob(jobPost,image);
         return jobService.getJobById(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable String postId){
        return jobService.deleteJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return jobService.searchByKeyword(keyword);
    }

    @GetMapping("jobposts/{postId}/image")
    public ResponseEntity<byte[]> getImageByJobId(@PathVariable String postId){
        JobPost jobPost = jobService.getImageBypostId(postId);
        return new ResponseEntity<>(jobPost.getImageData(), HttpStatus.OK);
    }
//    @RequestMapping({"/","home"})
//    public String home(){
//        return "home";
//    }
//
//    @RequestMapping("/addjob")
//    public String addJob(){
//        return "addjob";
//    }
//
//    @PostMapping("handleForm")
//    public String handleForm(JobPost jobPost){
//        jobService.addJob(jobPost);
//        return "success";
//    }
//
//    @GetMapping("viewalljobs")
//    public String viewJobs(Model m){
//        List<JobPost> jobs = jobService.getAllJobs();
//        m.addAttribute("jobPosts", jobs);
//        return "viewalljobs";
//    }
}
