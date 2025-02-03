package com.close.ai.dto.converter;

import com.close.ai.dto.PersonaDTO;
import com.close.ai.pojo.Persona;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface PersonaDTOConverter {
    PersonaDTO fromEntity(Persona persona);

    Persona toEntity(PersonaDTO personaDTO);
}
