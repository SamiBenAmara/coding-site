export interface User {
    firstName: string,
    lastName: string,
    email: string,
    password: string
}

export interface SignupForm {
    firstName: string,
    lastName: string,
    email: string,
    password: string,
}

export interface LoginForm {
    firstName: string,
    lastName: string
}

export interface SignupResponse {
    firstName: string,
    lastName: string,
    email: string
}

export interface PostModel {
    userId: number,
    postTitle: string,
    postCaption: string
}

export interface UserState {
    userId: number;
    email: string;
}