package com.ddd.domain.event;

/**
 * 用户删除领域事件
 *
 */
public class UserDeleteEvent extends BaseDomainEvent<Long> {
    public UserDeleteEvent(Long userId) {
        super(userId);
    }
}
