package trainual.userservice.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import trainual.userservice.dto.BadgeDto;
import trainual.userservice.dto.UserDataDto;
import trainual.userservice.model.Badge;
import trainual.userservice.model.UserData;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface UserDataMapper {

    UserDataDto toUserData(UserData user);
}
