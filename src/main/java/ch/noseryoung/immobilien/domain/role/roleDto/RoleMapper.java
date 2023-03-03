package ch.noseryoung.immobilien.domain.role.roleDto;

import ch.noseryoung.immobilien.domain.application.Application;
import ch.noseryoung.immobilien.domain.application.applicationDto.ApplicationDto;
import ch.noseryoung.immobilien.domain.role.Role;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface RoleMapper {
        RoleDTO toDTO(Role role);

        Role fromDTO(RoleDTO roleDTO);
    }

