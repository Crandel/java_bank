package com.banktest.security;

import com.banktest.models.Role;
import com.banktest.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TokenAuthenticationFilter extends GenericFilterBean {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
        throws IOException, ServletException
    {
        final HttpServletRequest httpRequest = (HttpServletRequest)request;

        //extract token from header
        final String accessToken = httpRequest.getHeader("header-name");
        if (null != accessToken) {
            //get and check whether token is valid ( from DB or file wherever you are storing the token)
            List<Role> authorities = new ArrayList<>();
            Role role_user = roleRepository.findByName("USER");
            authorities.add(role_user);
            //Populate SecurityContextHolder by fetching relevant information using token
            final User user = new User(
                "username",
                "password",
                true,
                true,
                true,
                true,
                authorities);
            final UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }

        chain.doFilter(request, response);
    }
}
