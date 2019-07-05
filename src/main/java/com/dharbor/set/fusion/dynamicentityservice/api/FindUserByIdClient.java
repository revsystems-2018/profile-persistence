package com.dharbor.set.fusion.dynamicentityservice.api;

import com.dharbor.set.fusion.dynamicentityservice.config.FeignHeaderConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rveizaga
 */
@FeignClient(
        name = ApiConstants.SecurityService.NAME_KEY,
        url = ApiConstants.SecurityService.URL_USER_BY_ID,
        configuration = FeignHeaderConfig.class
)
public interface FindUserByIdClient {

    @RequestMapping(
            value = "{userId}",
            method = RequestMethod.GET
    )
    Object findById(@PathVariable("userId") String userId);

}
