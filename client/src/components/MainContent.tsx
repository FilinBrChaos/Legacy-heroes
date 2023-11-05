import { Box, Divider, Typography, Container, Grid } from '@mui/material';
import {useEffect, useState} from 'react';
import { useLoaderData } from 'react-router-dom';
import { User } from '../utils/types';
import { UserCard } from './UserCard';
import {getAllFeedbacks} from "../store/thunks/feedback";
import {useDispatch} from "react-redux";
import { useAppDispatch } from '../store';
import {FeedbackComponent} from "./Feedback/Feedback";

const MainContent = () => {
  const users = useLoaderData() as [User];
  const [ currentUser, setCurrentUser ] = useState<User>(users[0]);
  const dispatch = useAppDispatch();

  const handleUserCardClick = (user: User)=>{
    setCurrentUser(user)
    dispatch(getAllFeedbacks(user.id));
  }

  return (
    <Grid container sx={{ w: '100%', h: '100%' }}>
      <Grid item xs={8}>
        <Box sx={{ pt: '10vh', pl: '4vw', backgroundColor: '#f9f9f9', minHeight: '1000px' }}>
          <Typography variant="h4">Directory</Typography>
          <Typography>Share your directory with your whole team to help them get to know each other.</Typography>
          <Box display="flex" flexDirection="row" flexWrap="wrap" marginTop="40px">
            {users.map((user, indx) => <UserCard key={indx} user={user} onClick={() => handleUserCardClick(user)} />)}
          </Box>
        </Box>
      </Grid>
      <Grid item xs={4}>
        <Box sx={{ p: '20px' }}>
          <Box display="flex" alignItems="center" flexDirection="column">
            <Box sx={{ overflow: 'hidden',
              minWidth: '150px',
              minHeight: '150px',
              maxHeight: '150px',
              maxWidth: '150px',
              borderRadius: 999,
              boxShadow: 2,
              mt: '50px' }}>
              <img style={{ width: '150px', height: '150px' }} src={currentUser?.avatar} />
            </Box>
            <Typography variant='h5' marginTop="20px">{currentUser?.name}</Typography>
            <Typography marginTop="5px">{currentUser?.title}</Typography>
          </Box>
          <Divider sx={{ my: "20px" }} />
          <Typography>Phone: +380 73 432 4300</Typography>
          <Typography>Email: google.email@gmail.com</Typography>
          <Divider sx={{ my: "20px" }} />
          <Typography>Feedback</Typography>
          <FeedbackComponent id={1} createDate={''} comment={'blah-bla-bla'} userId={206006} />
        </Box>
      </Grid>
    </Grid>
  );
};

export default MainContent;
