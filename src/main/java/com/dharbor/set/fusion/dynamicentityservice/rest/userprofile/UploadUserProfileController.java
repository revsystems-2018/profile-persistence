package com.dharbor.set.fusion.dynamicentityservice.rest.userprofile;

import com.dharbor.set.fusion.dynamicentityservice.model.Profile;
import com.dharbor.set.fusion.dynamicentityservice.service.UploadUserProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author rveizaga
 */
@Api(
        tags = UserProfileRESTController.TAG_NAME
)
@RestController
@Validated
public class UploadUserProfileController extends UserProfileRESTController {

    @Autowired
    private UploadUserProfileService service;

    @ApiOperation(
            value = "Upload user picture by userId"
    )
    @RequestMapping(
            path = "/users/{userId}/uploadPicture",
            consumes = {"multipart/form-data"},
            method = RequestMethod.POST
    )
    public ResponseEntity<Profile> uploadPicture(@PathVariable @NotNull @NotBlank String userId,
                                                 @RequestPart("file") @Valid MultipartFile file) {
        Profile profile = service.UploadPictureProfile(userId, file);

        return ResponseEntity.ok(profile);
    }
}
