export interface User {
  id: number;
  name: string;
  title: string;
  avatar: string;
  path: string;
}
  
export interface Feedback {
  id: number;
  createDate: string;
  userId: number;
  comment?: string;
  badgeUrl?: string;
  rewardPoints?: number;
}

export interface FeedbackUser {
  userId: number;
  nickname: string;
  rewardPointsAmount: number;
  amountToSend: number;
  feedbacks: Feedback[];
}

export interface Badge {
  id: number;
  badgeUrl: string;
}