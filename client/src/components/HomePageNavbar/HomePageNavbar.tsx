import React from 'react';
import styles from './HomePageNavbar.module.css';
import GroupsIcon from '@mui/icons-material/Groups';
import type { PAGE } from '../../types/types';


interface HomePageNavbarProps {
  setPage: React.Dispatch<React.SetStateAction<PAGE>>,
}

const HomePageNavbar: React.FC<HomePageNavbarProps> = ({ setPage }) => {
    
  return (
    <div className={styles.main}>
      <GroupsIcon />
      <input type='text' placeholder='Search...' />
      <button>Search</button>
      <button onClick={() => setPage('HOME')}>Home</button>
      <button>Jobs</button>
      <button>Projects</button>
      <button>Events</button>
      <button>Connect</button>
      <button onClick={() => setPage('PROFILE')}>Account</button>
      <button>Settings</button>
      <button>Log out</button>
    </div>
  )
}

export default HomePageNavbar