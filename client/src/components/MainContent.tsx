import { Box, Divider, Typography, Container, Grid } from '@mui/material';

const MainContent = () => {
  const user = {
    name: 'Username',
    work: 'UserWork',
    phone: '923828374',
    email: 'example@gmail.com'
  }
  return (
    <Grid container sx={{ w: '100%', h: '100%' }}>
      <Grid item xs={8}>
        <Box sx={{ pt: '10vh', pl: '4vw' }}>
          <h3>Directory</h3>
          <Typography>Share your directory with your whole team to help them get to know each other.</Typography>
        </Box>
      </Grid>
      <Grid item xs={4}>
        <Box sx={{ backgroundColor: 'gray' }}>
          <Box display="flex" alignItems="center" flexDirection="column">
            <Box sx={{ backgroundColor: 'black', minWidth: '100px', minHeight: '100px', maxHeight: '100px', maxWidth: '100px', borderRadius: 999 }}></Box>
            <Typography>Username</Typography>
            <Typography>User work</Typography>
          </Box>
          <Divider />
          
        </Box>
      </Grid>
    </Grid>
  );
};

export default MainContent;
