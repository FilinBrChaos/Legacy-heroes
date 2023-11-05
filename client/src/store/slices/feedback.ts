import { createSlice } from '@reduxjs/toolkit';

const initialFeedbackState = {
  loading: false,
  comment: '',
  points: 0,
  reward: null,
  userName: '',
  avatar: null,
  error: '',
};

const feedbackSlice = createSlice({
  name: 'counter',
  initialState: initialFeedbackState,
  reducers: {
    setLoading(state) {
      state.loading = true;
    },
    setFeedbackData(state, action) {
      state.loading = false;
      state.comment = action.payload.comment;
      state.points = action.payload.points;
      state.reward = action.payload.reward;
      state.userName = action.payload.userName;
      state.avatar = action.payload.avatar;
    },
    setError(state) {
      state.loading = false;
      state.error = 'Error';
    },
  },
});

export const feedbackSliceActions = feedbackSlice.actions;
export const feedbackSliceReducer = feedbackSlice.reducer;
