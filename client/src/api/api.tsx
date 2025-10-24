import type { User } from "../models/models";

export const signup = async (user: User): Promise<void> => {

    try {

        await fetch('http://localhost:8080/user/signup', {
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