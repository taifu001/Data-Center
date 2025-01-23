package com.close.ai.dto;


import com.close.ai.pojo.Organization;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-01-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {
    @NotNull(message = "组织ID不允许为空")
    private Long id;
    @NotNull(message = "组织名字不允许为空")
    private String name;

    private Integer state;

    private LocalDateTime createdTime;
}
