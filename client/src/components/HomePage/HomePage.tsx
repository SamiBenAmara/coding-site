import React from 'react';
import HomePageNavbar from '../HomePageNavbar/HomePageNavbar';
import styles from './HomePage.module.css';
import Post from '../Post/Post';

const HomePage = () => {
  return (
    <div className={styles.main}>
        <HomePageNavbar />
        <div className={styles.homePageBody}>
          <div className={styles.left}>
            Div
          </div>
          <div className={styles.center}>
            <Post />
          </div>
          <div className={styles.right}>
            Div
          </div>
        </div>
    </div>
  )
}

export default HomePage