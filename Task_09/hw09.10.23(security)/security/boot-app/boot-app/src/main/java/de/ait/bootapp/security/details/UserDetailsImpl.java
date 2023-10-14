package de.ait.bootapp.security.details;

import de.ait.bootapp.dto.ParticipantDto;
import de.ait.bootapp.repositories.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetailsService {


    private final ParticipantRepository participantRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<ParticipantDto> userOptional = participantRepository.findByName(username);

        if (userOptional.isPresent()) {
            ParticipantDto participantDto = userOptional.get();
            AuthenticatedUser authenticatedUser = new AuthenticatedUser(participantDto);
            return (UserDetails) authenticatedUser;
        } else {
            throw new UsernameNotFoundException(("User with name <" + username + "> not found"));
        }

    }
}
