import type { JobModel, PostModel, User, UserState } from "../models/models";

const BASE_URL = 'http://localhost:8080';

export const signupUser = async (user: User): Promise<UserState> => {

    try {

        const response = await fetch(`${BASE_URL}/user/signup`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(user)
        });

        if (!response.ok) {
            throw new Error("ERROR SIGNING UP USER");
        }

        const userState: UserState = await response.json();
        return userState;

    } catch (error) {
        console.log(error);
        throw error;
    }
}

export const loginUser = async (email: string, password: string): Promise<UserState> => {

    try {
    
        const response = await fetch(`${BASE_URL}/user/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ "email": email, "password": password })
        });

    if (!response.ok) {
        throw new Error("USER COULD NOT BE LOGGED IN");
    }

    const userState: UserState = await response.json();
    return userState;

    } catch (err) {
        console.log(err);
        throw err;
    }

}

export const createPost = async (postData: PostModel): Promise<void> => {

    try {

        await fetch(`${BASE_URL}/user/createPost`,  {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(postData)
        }).then(response => {
            if (!response.ok) {
                throw new Error("POST COULD NOT BE CREATED");
            }
        }).catch(err => {
            console.log(err);
        })

    } catch (err) {
        console.log(err);
    }
}

export const createJob = async (job: JobModel): Promise<JobModel> => {

    try {

        const response = await fetch(`${BASE_URL}/job/createJob`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(job)      
        });     

        if (!response.ok) {
            throw new Error("FAILED TO CREATE JOB");
        }

        const newJob: JobModel = await response.json();
        return newJob;

    } catch (err) {
        console.log(err);
        throw err;
    }
}