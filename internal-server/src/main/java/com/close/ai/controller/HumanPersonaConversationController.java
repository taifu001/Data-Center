package com.close.ai.controller;

import com.close.ai.dto.HumanPersonaConversationMessagesDTO;
import com.close.ai.enums.ResponseCode;
import com.close.ai.request.create.HumanPersonaConversationSaveRequest;
import com.close.ai.response.Response;
import com.close.ai.service.HumanPersonaConversationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getMessages")
    public Response<List<HumanPersonaConversationMessagesDTO>> getHumanPersonaConversationMessages(@RequestParam(required = false) Long id,
                                                                                                   @RequestParam(required = false) Long humanId,
                                                                                                   @RequestParam(required = false) Long personaId) {
        List<HumanPersonaConversationMessagesDTO> conversation = humanPersonaConversationService.getHumanPersonaConversationMessages(id, humanId, personaId);
        return Response.success(conversation);
    }
}
