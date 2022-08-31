
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.request;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
    
    @Size(min=3, max = 60)
    private String username;


    @Size(min = 6, max = 40)
    private String password;
}
