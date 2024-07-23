package uz.pdp.conf.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import uz.pdp.dao.PermissionRepository;
import uz.pdp.dao.RoleRepository;
import uz.pdp.dao.UserRepository;
import uz.pdp.model.AuthPermission;
import uz.pdp.model.AuthRole;
import uz.pdp.model.AuthUser;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("----------" + username + " ----------");
        AuthUser authUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));

        List<AuthRole> roles = roleRepository.findByUserId(authUser.getId());
        for (AuthRole role : roles) {
            List<AuthPermission> permissions = permissionRepository.findByRoleId(role.getId());
            role.setPermissions(permissions);
        }
        authUser.setRoles(roles);
        return new CustomUserDetails(authUser);
    }
}
