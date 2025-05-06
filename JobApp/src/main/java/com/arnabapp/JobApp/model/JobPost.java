package com.arnabapp.JobApp.model;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
public class JobPost {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;
    private String postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;


    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostProfile() {
        return postProfile;
    }

    public void setPostProfile(String postProfile) {
        this.postProfile = postProfile;
    }

    public List<String> getPostTechStack() {
        return postTechStack;
    }

    public void setPostTechStack(List<String> postTechStack) {
        this.postTechStack = postTechStack;
    }

    public int getReqExperience() {
        return reqExperience;
    }

    public void setReqExperience(int reqExperience) {
        this.reqExperience = reqExperience;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "imageData=" + Arrays.toString(imageData) +
                ", postId=" + postId +
                ", postProfile='" + postProfile + '\'' +
                ", postDesc='" + postDesc + '\'' +
                ", reqExperience=" + reqExperience +
                ", postTechStack=" + postTechStack +
                ", imageName='" + imageName + '\'' +
                ", imageType='" + imageType + '\'' +
                '}';
    }

    public JobPost(int jobId,byte[] imageData, String imageName, String imageType, String postDesc, String postId, String postProfile, List<String> postTechStack, int reqExperience) {
        this.jobId = jobId;
        this.imageData = imageData;
        this.imageName = imageName;
        this.imageType = imageType;
        this.postDesc = postDesc;
        this.postId = postId;
        this.postProfile = postProfile;
        this.postTechStack = postTechStack;
        this.reqExperience = reqExperience;
    }

    public JobPost(){

    }
}
