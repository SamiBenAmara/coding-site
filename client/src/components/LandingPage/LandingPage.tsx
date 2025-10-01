import React from 'react';
import styles from './LandingPage.module.css';
import LandingPageNavbar from '../LandingPageNavbar/LandingPageNavbar';
import QrCodeIcon from '@mui/icons-material/QrCode';;

const LandingPage = () => {
  return (
    <div className={styles.main}>
      <LandingPageNavbar />
      <div className={styles.landingPageBodyContainer}>
        <div className={styles.titleTextContainer}>
          <h1>Connecting developers worldwide</h1>
          <h3>Collaborate and share your projects with developers around the world</h3>
        </div>
        <QrCodeIcon />
      </div>
    </div>
  )
}

export default LandingPage