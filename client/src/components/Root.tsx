import Header from "./Header";
import MainContent from "./MainContent";
import { Box } from '@mui/material';

export function Root(): JSX.Element {
    return(
        <Box sx={{ w: '100vw', h: '100vh' }}>
            <Header />
            <MainContent />
        </Box>
    )
}