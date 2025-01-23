package com.close.ai.request;

import lombok.Data;

/**
 * @author nbwyctf
 * @since 2025-1-20
 */
@Data
public class OrganizationCreateRequest {
    private String organizationName;
    private String organizationType;
}
