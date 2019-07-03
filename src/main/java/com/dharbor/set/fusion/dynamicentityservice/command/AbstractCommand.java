package com.dharbor.set.fusion.dynamicentityservice.command;

import com.dharbor.set.fusion.dynamicentityservice.exception.CommandExceptionConverter;
import com.dharbor.set.social.common.hystrix.command.AbstractHystrixCommand;
import com.dharbor.set.social.common.hystrix.exception.ExceptionConverter;

/**
 * @author rvasquez
 */
abstract class AbstractCommand extends AbstractHystrixCommand {

    @Override
    protected ExceptionConverter getExceptionConverter() {
        return new CommandExceptionConverter();
    }
}
