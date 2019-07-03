package com.dharbor.set.fusion.dynamicentityservice.repository;

import com.dharbor.set.fusion.dynamicentityservice.model.Profile;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * @author rveizaga
 */
public interface ProfileRepository extends MongoRepository<Profile, String> {

    @ApiOperation(
            value = "findByUserId"
    )
    Profile findByUserId(@RequestParam String userId);

    @ApiOperation(
            value = "findById"
    )
    Optional<Profile> findById(@RequestParam String id);
}
