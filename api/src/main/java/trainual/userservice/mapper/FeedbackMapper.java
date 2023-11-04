package trainual.userservice.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import trainual.userservice.dto.FeedbackDto;
import trainual.userservice.dto.FeedbackRequestDto;
import trainual.userservice.model.Feedback;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface FeedbackMapper {

    @Mapping(source = "badgeUrl", target = "badgeUrl")
    FeedbackDto toFeedbackDto(Feedback feedback, String badgeUrl);

    Feedback toFeedbackModel(FeedbackRequestDto feedbackRequestDto);
}
