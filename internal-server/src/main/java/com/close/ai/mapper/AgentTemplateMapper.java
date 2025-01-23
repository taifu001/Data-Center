package com.close.ai.mapper;

import com.close.ai.pojo.AgentTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author nbwyctf
 * @since 2025-01-22
 */
@Mapper
public interface AgentTemplateMapper {
    AgentTemplate selectActiveAgentTemplateById(@Param("id") Long id);

    AgentTemplate fuzzySelectActiveAgentTemplateByName(@Param("name") String name);

    Integer releaseAgentTemplate(AgentTemplate agentTemplate);

    Integer insertAgentTemplate(AgentTemplate agentTemplate);

    Integer updateAgentTemplate(AgentTemplate agentTemplate);
}
