import { combineReducers } from '@reduxjs/toolkit';
import counterReducer from './slices/rewardCounter';
import { feedbackSliceReducer } from './slices/feedback';

export const rootReducer = combineReducers({
  counter: counterReducer,
  feedback: feedbackSliceReducer,
});
