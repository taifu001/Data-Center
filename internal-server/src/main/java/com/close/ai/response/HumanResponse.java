package com.close.ai.response;

import lombok.Data;


import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-02-05
 */
@Data
public class HumanResponse {
    private Long id;
    private Long userId;
    private Integer state;
    private String traitsJson;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
