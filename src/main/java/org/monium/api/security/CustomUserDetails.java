package org.monium.api.security;

import org.monium.api.user.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
  private static final String USER_ROLE = "ROLE_USER";
  private Collection<? extends GrantedAuthority> authorities;
  private String password;
  private String username;

  public CustomUserDetails(User user) {
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.authorities = Collections.singletonList(new SimpleGrantedAuthority(USER_ROLE));
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
