package com.coding_site.service;

import com.coding_site.model.Job;
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
}
