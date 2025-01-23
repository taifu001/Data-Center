package com.close.ai.mapper;


import com.close.ai.pojo.Organization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author taifu
 * @since 2025-01-20
 */
@Mapper
public interface OrganizationMapper {
    Organization selectOrganizationById(@Param("id") Long id);

    Organization selectActiveOrganizationById(@Param("id") Long id);

    List<Organization> selectAllActiveOrganizations();

    Organization selectActiveOrganizationByName(@Param("name") String name);

    Integer insertOrganization(Organization organization);

    Integer updateOrganization(Organization organization);
}
