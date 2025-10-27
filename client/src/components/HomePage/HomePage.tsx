import React, { useState } from 'react';
import HomePageNavbar from '../HomePageNavbar/HomePageNavbar';
import styles from './HomePage.module.css';
import { type PostModel } from '../../models/models';
import { createPost } from '../../api/api';

const HomePage = () => {

  const [postFormData, setPostFormData] = useState<PostModel>({ userId: 1, postTitle: "", postCaption: "" });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setPostFormData({ ...postFormData, [e.target.name]: e.target.value });
  }

  const handleSubmitPost = async () => {

    try {

      await createPost(postFormData);

    } catch (err) {
      console.log(err);
    }

  };

  return (
    <div className={styles.main}>
        <HomePageNavbar />
        <div className={styles.homePageBody}>
          <div className={styles.left}>
            Div
          </div>
          <div className={styles.center}>
            
            <div className={styles.createPostContainer}>
              <input name='postTitle' type='text' placeholder='Post Title' onChange={handleChange} />
              <input name='postCaption' type='text' placeholder='Post Caption' onChange={handleChange} />
              <button onClick={handleSubmitPost}>SUBMIT POST</button>
            </div>

          </div>
          <div className={styles.right}>
            Div
          </div>
        </div>
    </div>
  )
}

export default HomePage