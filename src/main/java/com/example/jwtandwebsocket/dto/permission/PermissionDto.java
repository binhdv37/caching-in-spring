package com.example.jwtandwebsocket.dto.permission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDto implements Serializable {

    private static final long serialVersionUID = -4439114469417994311L;

    private UUID id;
    private String name;
    private String key;
    private Long createdTime;
}
