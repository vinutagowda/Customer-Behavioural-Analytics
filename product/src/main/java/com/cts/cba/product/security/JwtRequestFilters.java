// package com.cts.cba.product.security;

// import java.io.IOException;

// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import com.cts.cba.product.service.UserSecurityService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// @Component
// public class JwtRequestFilters extends OncePerRequestFilter {

//     @Autowired
//     private UserSecurityService userSecurityService;

//     @Autowired
//     private JwtUtil jwtUtil;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {

//         final String authorizationHeader = request.getHeader("Authorization");

//         String username = null;
//         String jwt = null;

//         if (authorizationHeader.startsWith("Bearer ") && authorizationHeader != null) {
//             jwt=authorizationHeader.substring(7);
//             username=jwtUtil.extractUsername(jwt);
//         }
//     }

// }