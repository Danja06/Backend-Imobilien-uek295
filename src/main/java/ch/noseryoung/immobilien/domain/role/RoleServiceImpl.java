package ch.noseryoung.immobilien.domain.role;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findByRole(String role) {
        Optional<Role> optionalRole = roleRepository.findAllByRole(role);
            if (optionalRole.isPresent()) {
                return optionalRole.get();
            }
            throw new NoSuchElementException("role "+role+" does not exist");
        }
    @Override
    public Role findById(int roleId) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isPresent()){
            return optionalRole.get();
        }
        throw new NoSuchElementException("role with the id "+roleId+" does not exist");
    }

}
