package com.close.ai.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-02-05
 */
@Data
public class HumanResponse {
    private Long id;
    private Long userId;
    private String name;
    private Integer gender;
    private LocalDate birthday;
    private String traitsJson;
    private Integer state;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
