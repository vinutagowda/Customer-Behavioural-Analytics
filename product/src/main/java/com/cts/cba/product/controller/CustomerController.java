package com.cts.cba.product.controller;

import java.util.List;

import com.cts.cba.product.entity.Product;
import com.cts.cba.product.service.CustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "Customer", description = "A controller to activate endpoint related to properties of customer entity")
@RequestMapping("/customers")
@RefreshScope
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService service;

    // @Autowired
    // private UserSecurityService userSecurityService;

    // @Autowired
    // private JwtUtil jwtTokenUtil;

    // @Autowired
    // private AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.GET, value = "/soldlocationlist/{timeDuration}/{customerCategory}/{location}")
    @ApiOperation(value = "Gets list of locations", notes = "Generates list of average sales details based on customer geoagraphy")
    public List<Product> getAllByLocation(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Location of customers", required = true) @PathVariable String location) {

        logger.debug("Resquest: {} | {} | {}", timeDuration, customerCategory, location);
        List<Product> list = service.getAllByLocation(timeDuration, customerCategory, location);
        if (list.isEmpty()) {
            throw new RuntimeException("Failed Execution !");
        } else {
            logger.info("Response: Successfully Executed");
        }

        return list;

    }

    // @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    // public ResponseEntity<?> createAuthenticationToken(@RequestBody
    // AuthenticationRequest authenticationRequest)
    // throws Exception {
    // try {
    // authenticationManager.authenticate(new
    // UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
    // } catch (BadCredentialsException exception) {
    // throw new Exception("Incorrect username or password !", exception);
    // }

    // final UserDetails userDetails =
    // userSecurityService.loadUserByUsername(authenticationRequest.getUsername());

    // final String jwt = jwtTokenUtil.generateToken(userDetails);
    // return ResponseEntity.ok(new AuthenticationResponse(jwt));
    // }
}