import type { User } from "../models/models";

const BASE_URL = 'http://localhost:8080';

export const signupUser = async (user: User): Promise<void> => {

    try {

        await fetch(`${BASE_URL}/user/signup`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(user)
        }).then(response => {
            if (!response.ok) {
                throw new Error("USER COULD NOT BE CREATED");
            }
        });

    } catch (error) {
        console.log(error);
    }

}

export const loginUser = async (email: string, password: string): Promise<void> => {

    await fetch(`${BASE_URL}/user/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ "email": email, "password": password })
    }).then(response => {
        if (response.ok) {
            return response.json();
        }
    }).catch(err => {
        console.log(err.message);
    })

}