package com.close.ai.controller;

import com.close.ai.enums.ResponseCode;
import com.close.ai.request.create.PersonaCreateRequest;
import com.close.ai.response.Response;
import com.close.ai.service.PersonaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nbwyctf
 * @since 2025-02-02
 */
@RestController
@RequestMapping("/close.ai/datacenter/persona")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/create")
    public Response<ResponseCode> createPersona(@RequestBody PersonaCreateRequest request) {
        return Response.response(personaService.createPersona(request));
    }
}
