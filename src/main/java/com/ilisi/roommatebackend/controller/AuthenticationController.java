package com.ilisi.roommatebackend.controller;


import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.core.security.*;
import com.ilisi.roommatebackend.core.utility.ResponseBody;
import com.ilisi.roommatebackend.model.Colocataire;
import com.ilisi.roommatebackend.model.User;
import com.ilisi.roommatebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    protected JwtUtil jwtTokenUtil;

    @Autowired
    protected AppUserDetailsService appUserDetailsService;

    @Autowired
    protected UserService userService;

    @PostMapping
    public ResponseEntity<ResponseBody<JwtResponse>> insert(@RequestBody() JwtRequest request){

        try{
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()

            );
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        }catch(BadCredentialsException e){
            return new ResponseEntity<ResponseBody<JwtResponse>>
                    (new ResponseBody<JwtResponse>(null, "Username or password are incorrect"), HttpStatus.UNAUTHORIZED) ;
        }
        UserDetails userDetails=appUserDetailsService.loadUserByUsername(request.getUsername());
        User user=userService.findByUsername(userDetails.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new ResponseEntity<ResponseBody<JwtResponse>>
                (new ResponseBody<JwtResponse>(new JwtResponse(token, user)
                        , "Authentication success"), HttpStatus.OK) ;
        }

}
