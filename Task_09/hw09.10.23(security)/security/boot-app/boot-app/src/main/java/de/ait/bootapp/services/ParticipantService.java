package de.ait.bootapp.services;

import de.ait.bootapp.dto.ParticipantDto;

import javax.servlet.http.Part;

public interface ParticipantService {
    ParticipantDto register(ParticipantDto newParticipant);
}
