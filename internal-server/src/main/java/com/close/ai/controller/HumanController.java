package com.close.ai.controller;

import com.close.ai.dto.HumanDTO;
import com.close.ai.dto.converter.HumanDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.request.update.HumanUpdateRequest;
import com.close.ai.response.HumanResponse;
import com.close.ai.response.Response;
import com.close.ai.service.HumanService;
import org.springframework.web.bind.annotation.*;

/**
 * @author nbwyctf
 * @since 2025-02-05
 */
@RestController
@RequestMapping("/close.ai/datacenter/human")
public class HumanController {
    private final HumanService humanService;

    private final HumanDTOConverter humanDTOConverter;

    public HumanController(HumanService humanService,
                           HumanDTOConverter humanDTOConverter) {
        this.humanService = humanService;
        this.humanDTOConverter = humanDTOConverter;
    }

    @GetMapping("/getById/{humanId}")
    public Response<HumanResponse> getHumanById(@PathVariable Long humanId) {
        HumanDTO human = humanService.getHumanById(humanId, true);
        HumanResponse response = humanDTOConverter.buildResponse(human);
        return Response.success(response);
    }

    @PostMapping("/update")
    public Response<ResponseCode> updateHuman(@RequestBody HumanUpdateRequest request) {
        humanService.updateHuman(request);
        return Response.success();
    }
}
