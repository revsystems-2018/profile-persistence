package com.dharbor.set.fusion.dynamicentityservice.rest.client;

import com.dharbor.set.fusion.dynamicentityservice.model.User;
import com.dharbor.set.fusion.dynamicentityservice.service.client.FindUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author rveizaga
 */
@Api(
        tags = UserRESTController.TAG_NAME
)
@RestController
@Validated
public class FindUserController extends UserRESTController {

    @Autowired
    private FindUserService service;

    @ApiOperation(
            value = "Find user by userId"
    )
    @RequestMapping(
            path = "/{userId}",
            method = RequestMethod.GET
    )
    public ResponseEntity<User> findUser(@PathVariable @NotNull @NotBlank String userId) {
        User user = service.findUserById(userId);

        return ResponseEntity.ok(user);
    }
}
