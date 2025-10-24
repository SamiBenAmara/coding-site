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

export interface SignupResponse {
    firstName: string,
    lastName: string,
    email: string
}