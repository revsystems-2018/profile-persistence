package com.dharbor.set.fusion.dynamicentityservice.api;

import com.dharbor.set.fusion.dynamicentityservice.config.FeignHeaderConfig;
import com.dharbor.set.fusion.dynamicentityservice.domain.DMSDocument;
import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileRequest;
import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileResponse;
import com.dharbor.set.fusion.dynamicentityservice.dto.UPSUserProfileDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
            method = RequestMethod.GET
    )
    List<UserProfileResponse> findAllProfiles();

    @RequestMapping(
            value = "/profiles",
            method = RequestMethod.POST
    )
    UserProfileResponse createProfile(@RequestBody UPSUserProfileDTO dto);

    @RequestMapping(
            value = "/profiles/{profileId}/addSections",
            method = RequestMethod.POST
    )
    UserProfileRequest AddSectionsToProfile(@PathVariable("profileId") Long profileId,
                                            @RequestParam("sectionIds") List<Long> sectionIds);

    @RequestMapping(
            value = "/users/{userSlug}/profiles/{profileId}/sections/{sectionId}/attributes/{attributeId}/profilePic/upload",
            method = RequestMethod.POST
    )
    DMSDocument uploadPictureUserProfile(@PathVariable("userSlug") String userId,
                                         @PathVariable("profileId") Long profileId,
                                         @PathVariable("sectionId") Long sectionId,
                                         @PathVariable("attributeId") Long attributeId,
                                         @PathVariable("file") MultipartFile file);
}
