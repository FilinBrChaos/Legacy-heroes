import Header from '../Header';
import { Box, Button, Grid, TextField } from '@mui/material';
import { Image } from '@mui/icons-material';
import Typography from '@mui/material/Typography';
import * as React from 'react';
import {Feedback} from "../../utils/types";
import users from '../../mocked data/users.json';

export function FeedbackComponent({ id, createDate, userId, comment, badgeUrl, rewardPoints}: Feedback) {
  const imageUrl = users.find((user) => {
     return user.id === userId;
  })?.avatar;
  return (
    <Box sx={{ w: '100vw', h: '100vh' }}>
      <Header />
      <Grid container sx={{ w: '100%', h: '100%' }}>
        <Grid item xs={10}>
          <Box>
            <TextField placeholder="Search…" variant="outlined" />
            <Button placeholder={'Send'} />
          </Box>
        </Grid>
        <Grid item xs={10}>
          <img src={imageUrl}/>
          {/*{userName}*/}
          {comment && (
            <Typography gutterBottom variant="h5" component="p">
              {comment}
            </Typography>
          )}
          {/*{reward && reward}*/}
          {/*{points && (*/}
            <Typography gutterBottom variant="h5" component="p">
              {/*{points}*/}
            </Typography>
          {/*)}*/}
        </Grid>
      </Grid>
    </Box>
  );
}
