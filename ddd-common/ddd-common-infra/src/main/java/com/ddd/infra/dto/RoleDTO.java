package com.ddd.infra.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色数据
 *
 */
@Data
@NoArgsConstructor
public class RoleDTO {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色code
     */
    private String code;
}
