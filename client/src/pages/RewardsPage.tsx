import { Box, Container, Grid } from '@mui/material';

import * as React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import mug from '../assets/mug.png';
import thermalMug from '../assets/thermal-mug.png';
import fleecePlaid from '../assets/fleece-plaid.png';
import Header from '../components/Header';
import { useEffect, useState } from 'react';
import { ConfirmationGetRewardModal } from '../components/RewardsPage/ConfirmationGetRewardModal';

const rewardPresentsData = [
  {
    points: 150,
    image: thermalMug,
    title: 'Thermal Mug',
    description: 'Lorem ipsum dolor set amet Thermal Mug',
  },
  {
    points: 100,
    image: mug,
    title: 'Mug',
    description: 'Lorem ipsum dolor set amet Mug',
  },
  {
    points: 250,
    image: fleecePlaid,
    title: 'Fleece Throw',
    description:
      ' Perfect for the festive season to snuggle up in. With a plush fleece front and snuggle fleece back ' +
      'this is the perfect winter throw. Featuring Christmas gonks which will get you in the ...',
  },
  {
    points: 200,
    image: fleecePlaid,
    title: 'Fleece Throw',
    description:
      ' Perfect for the festive season to snuggle up in. With a plush fleece front and snuggle fleece back ' +
      'this is the perfect winter throw. Featuring Christmas gonks which will get you in the ...',
  },
];

const RewardsPage = ({ userPointsData = 153 }: { userPointsData?: number }) => {
  const [pageTopOffset, setPageTopOffset] = useState(0);
  const [userPoints, setUserPoints] = useState(userPointsData);
  const [currentUserPoints, setCurrentUserPoints] = useState(userPointsData);
  const [open, setOpen] = useState(false);

  const handleClickOpen = (currentUserPoints: number) => {
    setOpen(true);
    setCurrentUserPoints(currentUserPoints);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleGetReward = () => {
    setUserPoints(userPoints - currentUserPoints);
    handleClose();
  };

  const rewardPresentsWrapped = rewardPresentsData.map((item) => {
    const { image, title, points, description } = item;
    const buttonStyles =
      userPoints > points
        ? {
            color: 'green',
            backgroundColor: '#12b6345c',
            mr: '20px',
          }
        : {
            color: 'gray',
            backgroundColor: '#f1f1f1',
            mr: '20px',
            disabled: true,
          };

    return (
      <Grid item xs={4}>
        <Card sx={{ maxWidth: 345 }}>
          <CardMedia sx={{ height: '240px', width: '230px', margin: 'auto' }} image={image} title="green iguana" />
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
              {title}
            </Typography>
            <Typography variant="body2" color="text.secondary">
              {description}
            </Typography>
          </CardContent>
          <CardActions>
            <Button
              size="small"
              sx={buttonStyles}
              onClick={() => handleClickOpen(points)}
              disabled={!(userPoints > points)}
            >
              Get
            </Button>
            <Typography variant="body2" color="text.secondary">
              {points} points
            </Typography>
          </CardActions>
        </Card>
      </Grid>
    );
  });

  return (
    <>
      <Header />
      <Box
        sx={{
          backgroundColor: 'green',
          color: 'white',
          width: '100%',
          paddingTop: '6px',
          position: 'fixed',
          top: pageTopOffset > 16 ? '0' : '60px',
          zIndex: '190980'
        }}
      >
        <Typography gutterBottom variant="h5" component="div">
          You have {userPoints} points
        </Typography>
      </Box>
      <Container sx={{ paddingY: 20, paddingX: 20 }}>
        <Grid container spacing={2}>
          {rewardPresentsWrapped}
        </Grid>
        <ConfirmationGetRewardModal open={open} handleClose={handleClose} handleGetReward={handleGetReward} />
      </Container>
    </>
  );
};

export default RewardsPage;
