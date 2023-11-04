package trainual.userservice.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import trainual.userservice.dto.FeedbackDto;
import trainual.userservice.dto.FeedbackRequestDto;
import trainual.userservice.model.Feedback;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface FeedbackMapper {

    FeedbackDto toFeedbackDto(Feedback feedback);

    Feedback toFeedbackModel(FeedbackRequestDto feedbackRequestDto);
}
