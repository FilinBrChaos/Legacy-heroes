package trainual.userservice.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import trainual.userservice.dto.ReviewDto;
import trainual.userservice.dto.ReviewRequestDto;
import trainual.userservice.model.Review;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface ReviewMapper {

    ReviewDto toReviewDto(Review review);

    @Mapping(source = "userId", target = "userId")
    Review toReviewModel(ReviewRequestDto reviewRequestDto, Integer userId);
}
