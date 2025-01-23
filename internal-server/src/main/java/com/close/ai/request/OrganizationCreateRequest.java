package com.close.ai.request;

import lombok.Data;

/**
 * @author taifu
 * @since 2025-1-20
 */
@Data
public class OrganizationCreateRequest {
    private String organizationName;
    private String organizationType;
}
