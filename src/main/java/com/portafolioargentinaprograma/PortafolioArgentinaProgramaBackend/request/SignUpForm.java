
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.request;

import java.util.Set;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpForm {
    
    @Size(min = 3, max = 50)
    private String name;
    
    @Size(min = 3, max = 50)
    private String username;
    
    private Set<String> role;
    
    @Size(min = 8, max = 40)
    private String password;
    
    @Size(max = 60)
    private String email;
}
