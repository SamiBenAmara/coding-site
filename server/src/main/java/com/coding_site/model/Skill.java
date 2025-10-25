package com.coding_site.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skills_table")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long skillId;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    public Job job;

    @Column(name = "skill_name")
    public String skillName;

    public Skill() {

    }

    public Skill(Long skillId, Job job, String skillName) {
        this.skillId = skillId;
        this.job = job;
        this.skillName = skillName;
    }

    public Long getSkillId() {
        return skillId;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", job=" + job +
                ", skillName='" + skillName + '\'' +
                '}';
    }
}
