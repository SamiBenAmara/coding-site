import React, { useState, type ChangeEvent } from 'react';
import styles from './JobsPage.module.css';
import type { JobModel } from '../../models/models';
import { createJob } from '../../api/api';

const JobsPage: React.FC = () => {

  const [newJobData, setNewJobData] = useState<JobModel>({
    jobName: "",
    company: "",
    jobDepartment: "",
    lowSalary: 0,
    highSalary: 0,
    hourlyOrSalary: 0,
    city: "",
    stateProvince: "",
    country: "",
  });

  console.log(newJobData);

  const handleChange = (e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    setNewJobData({ ...newJobData, [e.target.name] : e.target.value });
  }

  const handleCreateJob = async (e: React.FormEvent<HTMLFormElement>) => {

    e.preventDefault();

    try {

      await createJob(newJobData);

    } catch (err) {
      console.log(err);
    }

  }

  return (
    <div className={styles.jobsPageContainer}>

      <div className={styles.jobsPageSidebar}>
        <button className={styles.jobsSidebarButton}>Add Job</button>
      </div>
      <div className={styles.jobsPageMainBody}>
        <form onSubmit={handleCreateJob}>
          <input name='jobName' type='text' placeholder='Enter a Job name' onChange={handleChange} />
          <input name='company' type='text' placeholder='Enter a Company name' onChange={handleChange} />
          <input name='jobDepartment' type='text' placeholder='Enter a Job Department' onChange={handleChange} />
          <input name='lowSalary' type='text' placeholder='Enter the low end of the salary range' onChange={handleChange} />
          <input name='highSalary' type='text' placeholder='Enter the high end of the salary range' onChange={handleChange} />
          <input name='hourlyOrSalary' type='text' placeholder='State whether the pay is hourly or salary' onChange={handleChange} />
          <input name='city' type='text' placeholder='Enter a city name' onChange={handleChange} />
          <input name='stateProvince' type='text' placeholder='Enter a state or province name' onChange={handleChange} />
          <input name='country' type='text' placeholder='Enter a country name' onChange={handleChange} />
          <button type='submit'>SUBMIT</button>
        </form>
      </div>

    </div>
  )
}

export default JobsPage