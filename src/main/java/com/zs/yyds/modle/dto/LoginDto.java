package com.zs.yyds.modle.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName LoginDto.java
 * @Description TODO
 * @createTime 2021年04月19日 10:28:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginDto {
    private String username;
    private String password;
}
