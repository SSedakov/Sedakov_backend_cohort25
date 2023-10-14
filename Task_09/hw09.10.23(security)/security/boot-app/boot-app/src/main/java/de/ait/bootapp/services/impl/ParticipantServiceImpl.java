package de.ait.bootapp.services.impl;

import de.ait.bootapp.dto.ParticipantDto;
import de.ait.bootapp.repositories.ParticipantRepository;
import de.ait.bootapp.services.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class ParticipantServiceImpl implements ParticipantService {
    ParticipantRepository participantRepository;
    @Override
    public ParticipantDto register(ParticipantDto newParticipant) {
        ParticipantDto participant = ParticipantDto.builder()
                .familyName(newParticipant.getFamilyName())
                .name(newParticipant.getName())
                .build();
        return participant;
    }
}
