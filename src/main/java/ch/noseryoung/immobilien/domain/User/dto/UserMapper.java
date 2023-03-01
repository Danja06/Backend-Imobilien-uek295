package ch.noseryoung.immobilien.domain.User.dto;

import ch.noseryoung.immobilien.domain.User.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "string", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User fromDTO(UserDTO.WithPassword dto);

    UserDTO toDTO(User user);
}
