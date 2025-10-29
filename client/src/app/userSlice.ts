import { createSlice } from '@reduxjs/toolkit';
import type { PayloadAction } from '@reduxjs/toolkit';
import type { UserState } from '../models/models';

const initialState: UserState = {
    userId: 0,
    email: ""
}

export const userSlice = createSlice({
    name: 'user',
    initialState,
    reducers: {
        loginSignup: (state, action: PayloadAction<UserState>) => {
            state.userId = action.payload.userId;
            state.email = action.payload.email;
        }
    }
})

export const { loginSignup } = userSlice.actions;
export default userSlice.reducer;
