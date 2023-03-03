package ch.noseryoung.immobilien.domain.application.applicationDto;

import ch.noseryoung.immobilien.domain.application.Application;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    ApplicationDto toDTO(Application application);

    Application fromDTO(ApplicationDto applicationDTO);
}
