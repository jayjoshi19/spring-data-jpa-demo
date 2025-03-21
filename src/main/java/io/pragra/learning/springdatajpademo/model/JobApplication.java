package io.pragra.learning.springdatajpademo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer jobApplicationId;
    private String jobTitle;
    private String jobDescription;
    @ManyToMany(mappedBy = "jobApplications")
    private Set<Student> appliedStudents;

    @Override
    public String toString() {
        return "JobApplication{" +
                "jobApplicationId=" + jobApplicationId +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                '}';
    }

    public Integer getJobApplicationId() {
        return jobApplicationId;
    }

    public void setJobApplicationId(Integer jobApplicationId) {
        this.jobApplicationId = jobApplicationId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
