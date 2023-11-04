import { combineReducers } from '@reduxjs/toolkit';
import counterReducer from './rewardCounter';

export const rootReducer = combineReducers({
  counter: counterReducer,
});
