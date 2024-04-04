package com.orcamo.hssanti.security.User.DTOs;

import com.orcamo.hssanti.security.User.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UserDTO {
    private Integer id;
    @NotBlank(message = "fullName name cannot be blank")
    @Size(max = 255, message = "fullName name must not exceed 255 characters")
    private String fullName;

    protected String profilePic;

    @NotNull(message = "Date of birth cannot be null")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "email cannot be blank")
    @Size(max = 1000, message = "Email must not exceed 1000 characters")
    private String email;

    private Role role;
}
