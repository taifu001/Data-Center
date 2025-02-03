package com.close.ai.controller;

import com.close.ai.enums.ResponseCode;
import com.close.ai.request.create.AgentTemplateCreateRequest;
import com.close.ai.response.Response;
import com.close.ai.service.AgentTemplateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nbwyctf
 * @since 2025-02-02
 */
@RestController
@RequestMapping("/close.ai/datacenter/agentTemplate")
public class AgentTemplateController {
    private final AgentTemplateService agentTemplateService;

    public AgentTemplateController(AgentTemplateService agentTemplateService) {
        this.agentTemplateService = agentTemplateService;
    }

    @PostMapping("/create")
    public Response<ResponseCode> createAgentTemplate(@RequestBody AgentTemplateCreateRequest request) {
        return Response.response(agentTemplateService.createAgentTemplate(request));
    }
}
