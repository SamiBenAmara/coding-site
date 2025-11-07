import React, { useEffect, useState } from 'react';
import styles from './ProfilePage.module.css';
import type { UserDto } from '../../models/models';

const ProfilePage = () => {

    const [userData, setUserData] = useState<UserDto>({ firstName: '', 
                                                        lastName: '',
                                                        userName: '',
                                                        email: '' });

    const userId = Number(localStorage.getItem('userId'));

    useEffect(() => {

        const getUserInfo = async (): Promise<void> => {
        
            try {
        
                const response = await fetch (`http://localhost:8080/user/getUserInfo?userId=${userId}`);
        
                if (!response.ok) {
                    throw new Error("getUserInfo API failed: Could not get user information");
                }
        
                const userInfo: UserDto = await response.json();
                setUserData(userInfo);
                
            } catch (err) {
                console.log(err);
                throw err;
            }
        
        }

        getUserInfo();
        
    }, []);

    return (
        <div className={styles.main}>
            
            <div className={styles.sideBar}>
                <button className={styles.sideBarButton}>Edit Information</button>
                <button className={styles.sideBarButton}>My Jobs</button>
                <button className={styles.sideBarButton}>My Connections</button>
            </div>
            <div className={styles.mainBody}>

            </div>
        </div>
    )

}

export default ProfilePage