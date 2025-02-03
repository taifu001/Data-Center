package com.close.ai.controller;

import com.close.ai.enums.ResponseCode;
import com.close.ai.request.create.HumanPersonaConversationSaveRequest;
import com.close.ai.response.Response;
import com.close.ai.service.HumanPersonaConversationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nbwyctf
 * @since 2025-02-03
 */
@RestController
@RequestMapping("/close.ai/datacenter/human-persona-conversation")
public class HumanPersonaConversationController {
    private final HumanPersonaConversationService humanPersonaConversationService;

    public HumanPersonaConversationController(HumanPersonaConversationService humanPersonaConversationService) {
        this.humanPersonaConversationService = humanPersonaConversationService;
    }

    @PostMapping("/save")
    public Response<ResponseCode> saveHumanPersonaConversation(@RequestBody HumanPersonaConversationSaveRequest request) {
        return Response.response(humanPersonaConversationService.saveHumanPersonaConversation(request));
    }
}
