package ch.noseryoung.immobilien.domain.user.dto;

import ch.noseryoung.immobilien.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User fromDTO(UserDTO.WithPassword dto);

    UserDTO toDTO(User user);
}
