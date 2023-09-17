package com.example.uis.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SetInfoRequest {

  private Long userId;
  private Long LvlId;
  private Long result;

}
