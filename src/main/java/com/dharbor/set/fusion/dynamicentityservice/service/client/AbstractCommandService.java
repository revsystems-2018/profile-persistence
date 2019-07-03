package com.dharbor.set.fusion.dynamicentityservice.service.client;

import com.dharbor.set.social.common.hystrix.command.AbstractHystrixCommand;
import com.dharbor.set.social.common.hystrix.command.HystrixCommandFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rvasquez
 */
abstract class AbstractCommandService {

    @Autowired
    private HystrixCommandFactory commandFactory;

    protected <T extends AbstractHystrixCommand> T createCommand(Class<T> clazz) {
        return commandFactory.createInstance(clazz);
    }

}
