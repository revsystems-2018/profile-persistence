package com.dharbor.set.fusion.dynamicentityservice.api;

import com.dharbor.set.fusion.dynamicentityservice.config.FeignHeaderConfig;
import com.dharbor.set.fusion.dynamicentityservice.dto.userProfileDTO;
import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rveizaga
 */
@FeignClient(
        name = ApiConstants.UserProfileService.NAME_KEY,
        url = ApiConstants.UserProfileService.URL_KEY,
        configuration = FeignHeaderConfig.class
)
public interface UserProfileClient {

    @RequestMapping(
            value = "/profiles",
            method = RequestMethod.POST
    )
    UserProfileResponse createProfile(@RequestBody userProfileDTO dto);

    @RequestMapping(
            value = "/sections",
            method = RequestMethod.POST
    )
    UserProfileResponse createSection(@RequestBody userProfileDTO dto);
}
