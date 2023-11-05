import { combineReducers } from '@reduxjs/toolkit';
import counterReducer from './rewardCounter';
import { feedbackSliceReducer } from './Feedback';

export const rootReducer = combineReducers({
  counter: counterReducer,
  feedback: feedbackSliceReducer,
});
