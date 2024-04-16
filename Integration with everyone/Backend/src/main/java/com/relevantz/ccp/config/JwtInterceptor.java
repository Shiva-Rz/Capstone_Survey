package com.relevantz.ccp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.relevantz.ccp.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@Component
public class JwtInterceptor implements HandlerInterceptor {
 
    private static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);
 
    @Autowired
    JwtUtil jwtUtil;
 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	System.out.println(request.getRequestURI());
    	System.out.println(request.getHeader("Authorization"));
        if (!request.getRequestURI().contains("forgetPassword")) {
        	if(!(request.getRequestURI().contains("login"))) {
        		if(!(request.getRequestURI().contains("ForgetVerifyOTP"))) {
        			if(!(request.getRequestURI().contains("updateForgetPassword"))) {
        				if(!(request.getRequestURI().contains("insertPassword"))) {
        					String token = request.getHeader("Authorization");
                            System.out.println(token);
                            if (token != null && token.startsWith("Bearer ")) {
                                String newToken = token.substring(7).trim();
                                try {
                                    if (jwtUtil.verifyToken(newToken) != null) {
                                        return true;
                                    } else {
                                        logger.error("Token verification failed.");
                                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                                        return false;
                                    }
                                } catch (Exception e) {
                                    logger.error("Exception while verifying token: {}", e.getMessage());
                                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                                    return false;
                                }
                            } else {
                                logger.error("Invalid token format." +token);
                                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                                return false;
                            }
        				}else {
        					return true;
        				}
        			}else {
        				return true;
        			}
        		}else {
        			return true;
        		}
        	}else {
        		return true;
        	}
        } else {
            return true;
        }
    }
}
