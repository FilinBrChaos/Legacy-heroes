import {Action, configureStore, ThunkAction} from '@reduxjs/toolkit';
import { rootReducer } from './rootReducer';
import {useDispatch} from "react-redux";

const store = configureStore({
  reducer: rootReducer,
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
// TODO: overwrite ReturnType with parameter
export type AppThunk<T = void> = ThunkAction<T, RootState, unknown, Action<string>>;
export const useAppDispatch = () => useDispatch<AppDispatch>();


export default store;
