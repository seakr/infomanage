package com.infomanage.commom.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginDto implements Serializable {
  @NotBlank(message = "账号不能为空")
  private String account;

  @NotBlank(message = "密码不能为空")
  private String password;
}
