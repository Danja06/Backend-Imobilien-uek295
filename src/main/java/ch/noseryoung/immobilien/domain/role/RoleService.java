package ch.noseryoung.immobilien.domain.role;

public interface RoleService {
        Role create(Role role);
        Role findByRole(String Role);
        Role findById(int roleId);
}
