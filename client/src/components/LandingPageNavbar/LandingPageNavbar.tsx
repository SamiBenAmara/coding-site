import React from 'react';
import GroupsIcon from '@mui/icons-material/Groups';
import styles from './LandingPageNavbar.module.css';
import { useNavigate } from 'react-router-dom';

const LandingPageNavbar = () => {

  const navigate = useNavigate();

  return (
    <div className={styles.main}>
        <div>
            <GroupsIcon />
            <button>Home</button>
            <button>About Us</button>
            <button>Contact Us</button>
            <button onClick={() => navigate('/login-signup')}>Log in / Sign up</button>
        </div>
    </div>
  )
}

export default LandingPageNavbar