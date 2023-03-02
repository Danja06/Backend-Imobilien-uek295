package ch.noseryoung.immobilien.domain.role;

import ch.noseryoung.immobilien.domain.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue
    public int roleId;
    @OneToMany(mappedBy = "role")
    private List<User> user;
    @Column(name = "role")
    public String role;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
