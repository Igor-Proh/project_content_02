package project_conten_02.prokhnov.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthenticationResponseDto {
    private String email;
    private String accessToken;
}
