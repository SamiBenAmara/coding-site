import React from 'react';
import GroupsIcon from '@mui/icons-material/Groups';
import styles from './LandingPageNavbar.module.css';

const LandingPageNavbar = () => {
  return (
    <div className={styles.main}>
        <div>
            <GroupsIcon />
            <button>Home</button>
            <button>About Us</button>
            <button>Contact Us</button>
            <button>Log in / Sign up</button>
        </div>
    </div>
  )
}

export default LandingPageNavbar