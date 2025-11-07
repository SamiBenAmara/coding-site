package com.coding_site.service;

import com.coding_site.model.Job;
import com.coding_site.model.Skill;
import com.coding_site.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {

        return jobRepository.findAll();

    }

    public Job createJob(Job job) {

        try {

            Job newJob = new Job();

            newJob.setJobName(job.getJobName());
            newJob.setCompany(job.getCompany());
            newJob.setJobDepartment(job.getJobDepartment());
            newJob.setLowSalary(job.getLowSalary());
            newJob.setHighSalary(job.getHighSalary());
            newJob.setHourlyOrSalary(job.getHourlyOrSalary());
            newJob.setCity(job.getCity());
            newJob.setStateProvince(job.getStateProvince());
            newJob.setCountry(job.getCountry());
            newJob.setJobSkill(job.getJobSkill());

            jobRepository.save(newJob);

            return newJob;

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

    }
}
