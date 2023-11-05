import { Card, CardActionArea, CardContent, CardMedia, Typography } from "@mui/material";
import { User } from "../utils/types";

export interface UserCardProps {
    user: User;
    onClick: () => void;
}

export function UserCard(props: UserCardProps): JSX.Element {
    return(
        <Card sx={{ width: 200, mr: "10px", mb: "10px" }}>
            <CardActionArea onClick={props.onClick}>
                <CardMedia sx={{ minHeight: '200px' }} component="img" image={props.user.avatar} />
                <CardContent>
                    <Typography>{props.user.name}</Typography>
                    <Typography variant="body2">{props.user.title}</Typography>
                </CardContent>
            </CardActionArea>
        </Card>
    )
}