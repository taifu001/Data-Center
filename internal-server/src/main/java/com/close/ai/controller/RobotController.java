package com.close.ai.controller;

import com.close.ai.enums.ResponseCode;
import com.close.ai.request.create.RobotCreateRequest;
import com.close.ai.response.Response;
import com.close.ai.service.RobotService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nbwyctf
 * @since 2025-01-25
 */
@RestController
@RequestMapping("/close.ai/datacenter/robot")
public class RobotController {
    private final RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping("/create")
    public Response<ResponseCode> createRobot(@RequestBody RobotCreateRequest request) {
        return Response.response(robotService.createRobot(request));
    }
}
