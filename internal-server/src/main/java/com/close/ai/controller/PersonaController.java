package com.close.ai.controller;

import com.close.ai.dto.PersonaDTO;
import com.close.ai.dto.converter.PersonaDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.request.create.PersonaCreateRequest;
import com.close.ai.request.update.PersonaUpdateRequest;
import com.close.ai.response.PersonaResponse;
import com.close.ai.response.Response;
import com.close.ai.service.PersonaService;
import org.springframework.web.bind.annotation.*;

/**
 * @author nbwyctf
 * @since 2025-02-02
 */
@RestController
@RequestMapping("/close.ai/datacenter/persona")
public class PersonaController {
    private final PersonaService personaService;

    private final PersonaDTOConverter personaDTOConverter;

    public PersonaController(PersonaService personaService,
                             PersonaDTOConverter personaDTOConverter) {
        this.personaService = personaService;
        this.personaDTOConverter = personaDTOConverter;
    }

    // todo 逻辑上应该是创建agent的时候自动创建persona，所以这个接口是临时的
    @PostMapping("/create")
    public Response<ResponseCode> createPersona(@RequestBody PersonaCreateRequest request) {
        personaService.createPersona(request);
        return Response.success();
    }

    @GetMapping("/getById/{personaId}")
    public Response<PersonaResponse> getPersonaById(@PathVariable Long personaId) {
        PersonaDTO persona = personaService.getPersonaById(personaId, true);
        PersonaResponse response = personaDTOConverter.buildResponse(persona);
        return Response.success(response);
    }

    @PostMapping("/update")
    public Response<ResponseCode> updatePersona(@RequestBody PersonaUpdateRequest request) {
        personaService.updatePersona(request);
        return Response.success();
    }
}
