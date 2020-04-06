package com.online.acs.api.controller;

import com.online.acs.api.model.AuthenticationResponse;
import com.online.acs.api.model.AutheticationRequest;
import com.online.acs.api.service.AcsUserDetailsService;
import com.online.acs.api.util.JwtUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/acs")
public class UserController {
    @Inject
    private AuthenticationManager authenticationManager;
    @Inject
    private AcsUserDetailsService userDetailsService;

    @PostMapping(path = "/token", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AutheticationRequest request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new UsernameNotFoundException("Username or password not valid");
        }
        //fetch user detailsS
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        //generate Jwt
        String jwt = JwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping(path = "/secure", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> secureAccess() {
        return ResponseEntity.ok("Secure access permitted!!!");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("API server up!!!");
    }
}
