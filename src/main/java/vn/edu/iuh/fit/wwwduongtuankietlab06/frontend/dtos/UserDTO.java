package vn.edu.iuh.fit.wwwduongtuankietlab06.frontend.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private String email;
    private String passwordHash;
}
