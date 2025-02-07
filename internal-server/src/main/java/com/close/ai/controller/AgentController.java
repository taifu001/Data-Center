package com.close.ai.controller;

import com.close.ai.enums.ResponseCode;
import com.close.ai.request.create.AgentCreateRequest;
import com.close.ai.response.Response;
import com.close.ai.service.AgentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nbwyctf
 * @since 2025-02-02
 */
@RestController
@RequestMapping("/close.ai/datacenter/agent")
public class AgentController {
    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/create")
    public Response<ResponseCode> createAgent(@RequestBody AgentCreateRequest request) {
        agentService.createAgent(request);
        return Response.success();
    }
}
