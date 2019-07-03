package com.dharbor.set.fusion.dynamicentityservice.rest.client;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author rveizaga
 */
@RequestMapping(value = UserRESTController.PATH)
public class UserRESTController {

    static final String PATH = "/users";

    static final String TAG_NAME = "user-rest-controller";
}
