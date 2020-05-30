package com.ericknavarro.covidapi.config;

import com.ericknavarro.covidapi.error.UnauthorizedException;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JwtFilter extends GenericFilterBean{
	
	private final String secreteKey;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		//Ya existe un header en http
		String authorizationHeader = httpRequest.getHeader("Authorization");
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			
			try {

				//El token está despues del indice 7
				String accessToken = authorizationHeader.substring(7);
				
				Claims claims = Jwts.parser()
						.setSigningKey(secreteKey)
						.parseClaimsJws(accessToken)
						.getBody();
				
				httpRequest.setAttribute("claims", claims);
				
			} catch (SignatureException e) {
				throw new UnauthorizedException();
			}
			
		} else {
			throw new ServletException("Missing or invalid Authorization");
		}
		
		chain.doFilter(httpRequest, httpResponse);
		
	}

}
