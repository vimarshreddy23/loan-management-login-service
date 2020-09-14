package com.loan.management.security.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.loan.management.login.model.UserDetailsEntity;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 275347623L;
	private int id;
	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;

	public CustomUserDetails(UserDetailsEntity user) {
		this.id = user.getUserId().intValue();
		this.username = user.getUserEmail();
		this.password = user.getUserPassword();
		this.active = Boolean.TRUE;

		String[] roles = { UserRole.ROLE_ADMIN.toString(),UserRole.ROLE_USER.toString() };
		this.authorities = Arrays.stream(roles).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
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
		return active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
