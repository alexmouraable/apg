package br.com.ratel.apg.domain.data.password.request;

import java.time.LocalDateTime;

import br.com.ratel.apg.domain.constant.PasswordType;
import br.com.ratel.apg.domain.constant.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExistsPasswordDataRequest {
    private ServiceType serviceType;
    private PasswordType passwordType;
    private LocalDateTime startOfDay;
    private LocalDateTime endOfDay;
}
