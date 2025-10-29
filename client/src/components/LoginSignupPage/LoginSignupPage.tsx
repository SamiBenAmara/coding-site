import React, { useState } from 'react';
import styles from './LoginSignupPage.module.css';
import { useNavigate } from 'react-router-dom';
import { type SignupForm, type User, type UserState } from '../../models/models';
import { signupUser, loginUser } from '../../api/api';
import { useDispatch } from 'react-redux';
import { loginSignup } from '../../app/userSlice';
import type { AppDispatch } from '../../app/store';

const LoginSignupPage: React.FC = () => {
  
    const [formData, setFormData] = useState<SignupForm>({ firstName: "", lastName: "", email: "", password: "" });

    const dispatch: AppDispatch = useDispatch();

    const navigate = useNavigate();

    const handleChange = (e: React.FormEvent<HTMLInputElement>): void => {
        setFormData({ ...formData, [e.currentTarget.name]: e.currentTarget.value })
    }

    const handleLoginSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        
        e.preventDefault();

        try {

            const response = await loginUser(formData.email, formData.password);

            dispatch(loginSignup(response));

            navigate('/home');

        } catch (error) {
            console.log(error);
        }

    }

    const handleSignupSubmit = async (e: React.FormEvent<HTMLFormElement>) => {

        e.preventDefault();

        try {

            const user: User = {
                firstName: formData.firstName,
                lastName: formData.lastName,
                email: formData.email,
                password: formData.password,
            }

            const response = await signupUser(user);

            dispatch(loginSignup(response));

            navigate('/home');
            
        } catch (error) {
            console.log(error);
        }

    }

    return (
        <div className={styles.mainContainer}>
            <div className={styles.bodyContainer}>
                <div className={styles.loginSignupContainer}>

                    <h3>Signup</h3>
                    <form onSubmit={handleSignupSubmit}>
                        
                        <input type="text" name="firstName" placeholder="First Name" onChange={handleChange}></input>
                        <input type="text" name="lastName" placeholder="Last Name" onChange={handleChange}></input>
                        
                        <input type="email" name="email" placeholder="Email" onChange={handleChange}></input>
                        <input type="password" name="password" placeholder="Password" onChange={handleChange}></input>
                        <input type="password" name="reenterpassword" placeholder="Re - enter Password" onChange={handleChange}></input>
                        
                        <button type='submit'>Submit</button>
                    </form>
                </div>
                <div className={styles.loginSignupContainer}>

                    <h3>Login</h3>
                    <form onSubmit={handleLoginSubmit}>
                        
                        <input type="email" name="email" placeholder="Email" onChange={handleChange}></input>
                        <input type="password" name="password" placeholder="Password" onChange={handleChange}></input>
                        
                        <button type='submit'>Submit</button>
                    </form>
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