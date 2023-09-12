package com.zomato.secuirty;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.zomato.service.JWTTokenUtil;
import com.zomato.service.ZomatoUserService;

@Component
public class JWTTokenAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	JWTTokenUtil jwtTokenUtil;

	@Autowired
	ZomatoUserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// verify Token Header is presented or not.
		// If Not, Presented, we will send Token Required.

		// If token presented, get UserName from token

		// if UserName is presented, validate the token w.r.to Expiry and user from
		// HttpRequest

		// if token valid
		// Security Layer will verify token user Name is presented in DB or not

		// allow request to Controller level

		String token = request.getHeader("Authorization");
		System.out.println("token : " + token);

		String userNameFromToken = null;

		if (token == null) {
			System.out.println("Please Add Token.. Token Missing .. Invalid Header");
		} else {
			userNameFromToken = this.jwtTokenUtil.getUserNameFromToken(token);
		}

		if (userNameFromToken != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			// DB check
			// Security Layer will verify user Name is presented in DB or not
			UserDetails userDetails = this.userService.loadUserByUsername(userNameFromToken);

			// validate JWT token : Time 3 mins & userName

			boolean isValidToken = this.jwtTokenUtil.isValidtoken(userDetails.getUsername(), token);

			if (isValidToken) {
				// Update SecurityContext data for that user

				// Spring Security Layer provide a token class . and as part of token class we
				// are going to pass User Information

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			} else {
				System.out.println("Token is InValid.. Please come with Valid token");
			}

			// allow request to Controller level

		}

		// Next Filter forwarding
		filterChain.doFilter(request, response);

	}

}
