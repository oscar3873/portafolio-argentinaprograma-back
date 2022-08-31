
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.controllers;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Usuario;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.jwt.JwtProvider;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Role;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.RoleName;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys.RoleRepository;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys.UsuarioRepository;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.request.LoginForm;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.request.SignUpForm;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.response.JwtResponse;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthAPIController {
        /*Se encarga de la inyeccion de dependencias*/
    @Autowired
    /*Una interfaz encargada de la autenticacion con un unico metodo authenticate*/
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        /*Una vez que se ha autenticado la solicitud la autenticación generalmente 
        se almacenará en un SecurityContext local de subproceso administrado por 
        SecurityContextHolder mediante el mecanismo de autenticación que se está utilizando*/
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("El nombre de usuario ya esta en uso",
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("El email ya esta en uso",
                    HttpStatus.BAD_REQUEST);
        }

        //Creando el usuario
        Usuario user = new Usuario(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
        	switch(role) {
	    		case "admin":
	    			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                                    .orElseThrow(() -> new RuntimeException("ERROR: Rol de usuario no encontrado."));
	    			roles.add(adminRole);
	    			
	    			break;
	    		case "user":
                                Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                                    .orElseThrow(() -> new RuntimeException("ERROR: Rol de usuario no encontrado."));
	        		roles.add(userRole);
	            	
	    			break; 		        			
        	}
        });
        
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok().body("Usuario Registrado Correctamente");
    }
}
