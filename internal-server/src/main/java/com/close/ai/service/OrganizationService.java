package com.close.ai.service;

import com.close.ai.dto.OrganizationDTO;
import com.close.ai.dto.converter.OrganizationDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.enums.pojo.OrganizationTypeEnum;
import com.close.ai.mapper.OrganizationMapper;
import com.close.ai.pojo.Organization;
import com.close.ai.utils.IdUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static com.close.ai.enums.ResponseCode.*;

/**
 * @author nbwyctf
 * @since 2025-01-20
 */
@Service
public class OrganizationService {
    private final OrganizationMapper organizationMapper;
    private final OrganizationDTOConverter organizationDTOConverter;
    private Map<String, Long> ORGANIZATION_MAP = new HashMap<>();

    // 构造器注入
    @Autowired
    public OrganizationService(OrganizationMapper organizationMapper,
                               OrganizationDTOConverter organizationDTOConverter) {
        this.organizationMapper = organizationMapper;
        this.organizationDTOConverter = organizationDTOConverter;
    }

    @PostConstruct
    public void init() {
        // 初始化 ORGANIZATION_MAP
        ORGANIZATION_MAP.put("SYSTEM", 140465719845457920L);
        ORGANIZATION_MAP.put("INTERNAL DEVELOPER", 140466000234680320L);
        ORGANIZATION_MAP.put("INTERNAL TESTER", 140466035345199104L);
        ORGANIZATION_MAP.put("REGULAR USER", 140466131797413888L);
    }

    public Map<String, Long> getOrganizationMap() {
        return ORGANIZATION_MAP;
    }

    public Long getOrganizationId(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        return ORGANIZATION_MAP.get(name);
    }

    /**
     * 根据组织ID获取组织信息
     *
     * @param id 组织ID
     * @return 组织信息
     */
    public OrganizationDTO getOrganizationById(Long id, boolean isActive) {
        if (id == null) {
            return null;
        }
        Organization organization = isActive
                ? organizationMapper.selectActiveOrganizationById(id)
                : organizationMapper.selectOrganizationById(id);
        if (organization == null) {
            return null;
        }
        return organizationDTOConverter.fromEntity(organization);
    }


    /**
     * 创建组织
     * @param organizationName 组织名称
     * @return Response
     */
    public ResponseCode createOrganization(String organizationName, String typeStr) {
        // 校验组织名字
        if (organizationName == null || organizationName.isEmpty()) {
            return ORGANIZATION_NAME_IS_EMPTY;
        }
        // 检查是否已经存在该组织
        if (organizationMapper.selectActiveOrganizationByName(organizationName) != null) {
            return ORGANIZATION_NAME_IS_REPEAT;
        }

        // 检查并获取组织类型
        OrganizationTypeEnum organizationType = OrganizationTypeEnum.fromType(typeStr);


        Organization organization = new Organization();
        IdUtil.SnowflakeIdGenerator snowflake = IdUtil.getSnowflake();

        organization.setId(snowflake.nextId());
        organization.setName(organizationName);
        organization.setType(organizationType);

        organization.setIsDeleted(false);

        organizationMapper.insertOrganization(organization);

        return OK;
    }


}
