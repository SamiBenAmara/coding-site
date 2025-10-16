import React, { useState } from 'react';
import styles from './LoginSignupPage.module.css';
import { useNavigate } from 'react-router-dom';

const LoginSignupPage: React.FC = () => {
  
    const [loginSignup, setLoginSignup] = useState<boolean>(true);

    const navigate = useNavigate();

    const login = (): void => {

    };
  
    const signup = (): void => {

    }

    return (
        <div className={styles.mainContainer}>
            <div className={styles.bodyContainer}>
                <div className={styles.loginSignupContainer}>
                    <h3>{loginSignup ? "Login" : "Signup"}</h3>
                    <button onClick={() => setLoginSignup(!loginSignup)}>{loginSignup ? "Login" : "Signup"}</button>
                    {
                        !loginSignup ? (
                            <>
                                <input type="text" name="firstname" placeholder="First Name"></input>
                                <input type="text" name="lastname" placeholder="Last Name"></input>
                            </>
                        ) : null
                    }
                    <input type="email" name="email" placeholder="Email"></input>
                    <input type="password" name="password" placeholder="Password"></input>
                    {
                        !loginSignup ? (
                            <input type="password" name="reenterpassword" placeholder="Re - enter Password"></input>
                        ) : null
                    }
                    <button onClick={() => loginSignup ? login() : signup()}>{loginSignup ? "Login" : "Signup"}</button>
                    <button onClick={() => navigate('/')}>BACK</button>
                </div>
                <div className={styles.headerTextContainer}>
                    <h1>Begin your journey</h1>
                </div>
            </div>
        </div>
    );
}

export default LoginSignupPage;