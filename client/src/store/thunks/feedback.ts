import {Feedback} from "../../utils/types";
import {getUserFeedbacks} from "../../api/FeedbackServiceManager";
import {AppThunk} from "../../store/index";
import {feedbackSliceActions} from "../../store/slices/feedback";

export const getAllFeedbacks = (id=2):AppThunk=>async (dispatch)=>{
  dispatch(feedbackSliceActions.setLoading());

  const result:Feedback[] | undefined = await getUserFeedbacks(id);
  if (result) {
    dispatch(feedbackSliceActions.setFeedbackData(result))
  } else {
    dispatch(feedbackSliceActions.setError())
  }
}