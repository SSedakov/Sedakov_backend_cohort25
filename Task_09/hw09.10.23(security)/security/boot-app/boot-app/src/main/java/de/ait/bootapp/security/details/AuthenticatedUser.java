package de.ait.bootapp.security.details;

import de.ait.bootapp.dto.ParticipantDto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Collections;



public class AuthenticatedUser implements  UserDetails{

    private final ParticipantDto participantDto;

    public AuthenticatedUser(ParticipantDto participantDto) {
        this.participantDto = participantDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return Collections.singleton(new SimpleGrantedAuthority(participantDto.getRole().toString()));
    }

    @Override
    public String getPassword() {
        return participantDto.getName();
    }

    @Override
    public String getUsername() {
        return participantDto.getName();
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
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
