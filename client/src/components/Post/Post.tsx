import React from 'react';
import styles from './Post.module.css';

const Post = () => {
  return (
    <div className={styles.main}>
      <div className={styles.imageDiv}>
        <b>Image goes here</b>
      </div>
      <div className={styles.textDiv}>
        Text goes here
      </div>
      <div className={styles.buttonDiv}>
        <button>Like</button>
        <button>Comment</button>
        <button>Share</button>
      </div>
    </div>
  )
}

export default Post