package org.monium.api.security;

import org.monium.api.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
  private Collection<? extends GrantedAuthority> authorities;
  private String password;
  private String username;

  public CustomUserDetails(User user) {
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.authorities = translate(user.getRole());
  }

  private Collection<? extends GrantedAuthority> translate(@NotNull String role) {
    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    String name = role.toUpperCase();
    if (!name.startsWith("ROLE_")) {
      name = "ROLE_" + name;
    }
    grantedAuthorities.add(new SimpleGrantedAuthority(name));

    return grantedAuthorities;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
