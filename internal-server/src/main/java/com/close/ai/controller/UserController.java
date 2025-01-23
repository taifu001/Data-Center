package com.close.ai.controller;

import com.close.ai.dto.UserDTO;
import com.close.ai.enums.ResponseCode;
import com.close.ai.request.UserCreateRequest;
import com.close.ai.response.Response;
import com.close.ai.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nbwyctf
 * @since 2025-01-21
 */
@RestController
@RequestMapping("/close.ai/datacenter/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 暂时用于测试
    @PostMapping("/create/RegularUser/withBlankHuman")
    public Response<ResponseCode> createRegularUserWithBlankHuman(@RequestBody UserCreateRequest request) {
        UserDTO userDTO = request.toUserDTO();
        ResponseCode code = userService.createRegularUser(userDTO, true);
        return Response.response(code);
    }

    // 暂时用于测试
    @PostMapping("/create/SystemUser/withBlankHuman")
    public Response<ResponseCode> createSystemUserWithBlankHuman(@RequestBody UserCreateRequest request) {
        UserDTO userDTO = request.toUserDTO();
        ResponseCode code = userService.createSystemUser(userDTO, true);
        return Response.response(code);
    }
}
