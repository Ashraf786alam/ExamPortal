package com.exampleportal.Config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exampleportal.ServiceImpl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter  extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceimpl;
	
	@Autowired
	private JwtUtil jwtutil;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader=request.getHeader("Authorization");
		System.out.println(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer")) {
			
			jwtToken=requestTokenHeader.substring(7);
			try {
				
				username=this.jwtutil.extractUsername(jwtToken);
			}
			
			catch(ExpiredJwtException e) {
				
				e.printStackTrace();
				System.out.println("JWT token has expired");
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
		}
		else {
			System.out.println("Invalid Token,not start with bearer String");
		}
		
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			final UserDetails userdetails=this.userDetailsServiceimpl.loadUserByUsername(username);
			
			if(this.jwtutil.validateToken(jwtToken, userdetails)) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
			else {
				System.out.println("Token is not valid");
			}
		
		
		
		filterChain.doFilter(request, response);
	}
	
	
}
