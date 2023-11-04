package trainual.userservice.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import trainual.userservice.dto.BadgeDto;
import trainual.userservice.model.Badge;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface BadgeMapper {

    BadgeDto toBadgeDto(Badge badge);
}
