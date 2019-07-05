package com.dharbor.set.fusion.dynamicentityservice.repository;

import com.dharbor.set.fusion.dynamicentityservice.model.UserProfile;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * @author rveizaga
 */
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {

    @ApiOperation(
            value = "findById"
    )
    Optional<UserProfile> findById(@RequestParam String id);
}
