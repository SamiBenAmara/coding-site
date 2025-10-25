import React from 'react';
import styles from './HomePageNavbar.module.css';
import GroupsIcon from '@mui/icons-material/Groups';

const HomePageNavbar = () => {
  return (
    <div className={styles.main}>
      <GroupsIcon />
      <input type='text' placeholder='Search...' />
      <button>Search</button>
      <button>Home</button>
      <button>Jobs</button>
      <button>Projects</button>
      <button>Events</button>
      <button>Connect</button>
      <button>Account</button>
      <button>Settings</button>
      <button>Log out</button>
    </div>
  )
}

export default HomePageNavbar