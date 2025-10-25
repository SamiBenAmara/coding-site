package com.coding_site.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "jobs_table")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long jobId;

    @Column(name = "job_name")
    public String jobName;

    @Column(name = "company_name")
    public String company;

    @Column(name = "job_department")
    public String jobDepartment;

    @Column(name = "salary_low")
    public Long lowSalary;

    @Column(name = "salary_high")
    public Long highSalary;

    @Column(name = "salary_hourly")
    public Long hourlySalary;

    @Column(name = "city")
    public String city;

    @Column(name = "stateProvince")
    public String stateProvince;

    @Column(name = "country")
    public String country;

    @OneToMany(mappedBy = "job")
    public List<Skill> jobSkill;

    public Long getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobDepartment() {
        return jobDepartment;
    }

    public void setJobDepartment(String jobDepartment) {
        this.jobDepartment = jobDepartment;
    }

    public Long getLowSalary() {
        return lowSalary;
    }

    public void setLowSalary(Long lowSalary) {
        this.lowSalary = lowSalary;
    }

    public Long getHighSalary() {
        return highSalary;
    }

    public void setHighSalary(Long highSalary) {
        this.highSalary = highSalary;
    }

    public Long getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(Long hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", company='" + company + '\'' +
                ", jobDepartment='" + jobDepartment + '\'' +
                ", lowSalary=" + lowSalary +
                ", highSalary=" + highSalary +
                ", hourlySalary=" + hourlySalary +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
