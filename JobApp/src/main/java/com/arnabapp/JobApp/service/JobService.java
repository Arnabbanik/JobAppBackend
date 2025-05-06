package com.arnabapp.JobApp.service;

import com.arnabapp.JobApp.model.JobPost;
import com.arnabapp.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public JobPost addJob(JobPost job, MultipartFile image) throws IOException {
        job.setImageName(image.getOriginalFilename());
        job.setImageType(image.getContentType());
        job.setImageData(image.getBytes());
        jobRepo.save(job);
        return job;
    }

    public List<JobPost> getAllJobs(){
        return jobRepo.findAll();
    }

    public JobPost getJobById(String postId) {
        return jobRepo.findByPostId(postId);
    }

    public void updateJob(JobPost jobPost, MultipartFile image) throws IOException {
        JobPost jp = jobRepo.findByPostId(jobPost.getPostId());
        if(jp != null){
            jp.setPostId(jobPost.getPostId());
            jp.setPostProfile(jobPost.getPostProfile());
            jp.setPostDesc(jobPost.getPostDesc());
            jp.setReqExperience(jobPost.getReqExperience());
            jp.setPostTechStack(jobPost.getPostTechStack());
            jp.setImageName(image.getOriginalFilename());
            jp.setImageType(image.getContentType());
            jp.setImageData(image.getBytes());
        }
        jobRepo.save(jp);
    }

    @Transactional
    public String deleteJob(String postId) {
        JobPost job = jobRepo.findByPostId(postId);

        jobRepo.delete(job);
        return "User with ID " + postId + " deleted successfully.";
    }

    public List<JobPost> searchByKeyword(String keyword) {
        return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }

    public JobPost getImageBypostId(String postId) {
        return jobRepo.findByPostId(postId);
    }
}
