import { Feedback, Badge, FeedbackUser } from '../utils/types';
import secrets from '../.env/secrets.json'

const baseUrl = secrets.HEROKU_BASE_URL;

export async function putFeedback(feedback: Feedback): Promise<Feedback | undefined> {
    const rawResponse = await fetch(baseUrl + `/feedback`, { method: 'PUT', body: JSON.stringify(feedback) });
    const response = await rawResponse.json()
    if (response) return response.body as Feedback;
}

export async function getFeedbackById(id: number): Promise<Feedback | undefined> {
    const rawResponse = await fetch(baseUrl + `/feedback/${id}`, { method: 'GET' });
    const response = await rawResponse.json()
    if (response) return response as Feedback;
}

export async function getUserFeedbacks(userId: number): Promise<Feedback[] | undefined> {
    const rawResponse = await fetch(baseUrl + `/feedback/user/${userId}`, { method: 'GET' });
    const response = await rawResponse.json()
    if (response) return response as Feedback[];
}

export async function getAllBadges(): Promise<Badge[] | undefined> {
    const rawResponse = await fetch(baseUrl + `/badge/all`, { method: 'GET' });
    const response = await rawResponse.json()
    if (response) return response as Badge[];
}

export async function getUserData(userId: number): Promise<FeedbackUser | undefined> {
    const rawResponse = await fetch(baseUrl + `/user/${userId}`, { method: 'GET' });
    const response = await rawResponse.json()
    if (response) return response as FeedbackUser;
}
