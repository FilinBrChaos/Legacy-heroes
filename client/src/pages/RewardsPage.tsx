import { Container, Grid} from '@mui/material';

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
import Header from "../components/Header";


const RewardsPage = () => {
  return (
    <>
      <Header/>
    <Container sx={{paddingY: 20, paddingX: 20}}>
      <Grid container spacing={2}>
        <Grid item xs={4}>
          <Card sx={{ maxWidth: 345 }}>
            <CardMedia
              sx={{ height: '240px', width: '230px', margin: 'auto' }}
              image={thermalMug}
              title="green iguana"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                Thermal Mug
              </Typography>
              <Typography variant="body2" color="text.secondary">
                Perfect for the festive season to snuggle up in. With a plush fleece front and
                snuggle fleece back this is the perfect winter throw.
                Featuring Christmas gonks which will get you in the ...
              </Typography>
            </CardContent>
            <CardActions>
              <Button size="small" sx={{color: 'green', backgroundColor: '#12b6345c', mr: '20px'}}>Get</Button>
              <Typography variant="body2" color="text.secondary">
                150 points
              </Typography>
            </CardActions>
          </Card>
        </Grid>
        <Grid item xs={4}>
          <Card sx={{ maxWidth: 345 }}>
            <CardMedia
              sx={{ height: '240px', width: '230px', margin: 'auto' }}
              image={mug}
              title="green iguana"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                Mug
              </Typography>
              <Typography variant="body2" color="text.secondary">
                Lizards are a widespread group of squamate reptiles, with over 6,000
                species, ranging across all continents except Antarctica
              </Typography>
            </CardContent>
            <CardActions>
              <Button size="small" sx={{color: 'green', backgroundColor: '#12b6345c', mr: '20px'}}>Get</Button>
              <Typography variant="body2" color="text.secondary">
                100 points
              </Typography>
            </CardActions>
          </Card>
        </Grid>
        <Grid item xs={4}>
          <Card sx={{ maxWidth: 345 }}>
            <CardMedia
              sx={{ height: '240px', width: '230px', margin: 'auto' }}
              image={fleecePlaid}
              title="green iguana"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                Fleece Throw
              </Typography>
              <Typography variant="body2" color="text.secondary">
                Perfect for the festive season to snuggle up in. With a plush fleece front and
                snuggle fleece back this is the perfect winter throw.
                Featuring Christmas gonks which will get you in the ...
              </Typography>
            </CardContent>
            <CardActions>
              <Button size="small" sx={{color: 'gray', backgroundColor: '#f1f1f1', mr: '20px'}} disabled>Get</Button>
              <Typography variant="body2" color="text.secondary">
                250 points
              </Typography>
            </CardActions>
          </Card>
        </Grid>
        <Grid item xs={8}>
          <Card sx={{ maxWidth: 345 }}>
            <CardMedia
              sx={{ height: '240px', width: '230px', margin: 'auto' }}
              image={fleecePlaid}
              title="green iguana"
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                Fleece Throw
              </Typography>
              <Typography variant="body2" color="text.secondary">
                Perfect for the festive season to snuggle up in. With a plush fleece front and
                snuggle fleece back this is the perfect winter throw.
                Featuring Christmas gonks which will get you in the ...
              </Typography>
            </CardContent>
            <CardActions>
              <Button size="small" sx={{color: 'gray', backgroundColor: '#f1f1f1', mr: '20px'}} disabled>Get</Button>
              <Typography variant="body2" color="text.secondary">
                200 points
              </Typography>
            </CardActions>
          </Card>
        </Grid>
      </Grid>
    </Container>
      </>
  );
};

export default RewardsPage;
