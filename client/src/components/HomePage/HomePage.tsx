import React, { useState } from 'react';
import HomePageNavbar from '../HomePageNavbar/HomePageNavbar';
import styles from './HomePage.module.css';
import HomePageBody from '../HomePageBody/HomePageBody';
import ProfilePage from '../ProfilePage/ProfilePage';
import type { PAGE } from '../../types/types';
import JobsPage from '../JobsPage/JobsPage';

const HomePage = () => {

  const [page, setPage] = useState<PAGE>('HOME');

  return (
    <div className={styles.main}>
        <HomePageNavbar setPage={setPage} />
        { page === 'HOME' && <HomePageBody />  }
        { page === 'PROFILE' && <ProfilePage /> }
        { page === 'JOBS' && <JobsPage /> }
    </div>
  )
}

export default HomePage