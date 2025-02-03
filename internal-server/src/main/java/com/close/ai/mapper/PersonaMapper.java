package com.close.ai.mapper;

import com.close.ai.pojo.Persona;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper
public interface PersonaMapper {
    Persona selectPersonaById(Long id);

    Persona selectActivePersonaById(Long id);

    Integer insertPersona(Persona persona);

    Integer updatePersona(Persona persona);
}
