package com.close.ai.controller;

import com.close.ai.enums.ResponseCode;
import com.close.ai.request.create.OrganizationCreateRequest;
import com.close.ai.response.Response;
import com.close.ai.service.OrganizationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nbwyctf
 * @since 2025-01-19
 */
@RestController
@RequestMapping("/close.ai/datacenter/organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("/create")
    public Response<ResponseCode> createOrganization(@RequestBody OrganizationCreateRequest request) {
        ResponseCode code = organizationService.createOrganization(request.getOrganizationName(), request.getOrganizationType());
        return Response.response(code);
    }

}
