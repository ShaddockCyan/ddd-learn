package com.ddd.domain.event;

import com.ddd.infra.domain.AuthorizeDO;

/**
 * 用户新增领域事件
 *
 */
public class UserCreateEvent extends BaseDomainEvent<AuthorizeDO> {
    public UserCreateEvent(AuthorizeDO user) {
        super(user);
    }
}