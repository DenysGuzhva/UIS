package com.example.uis.service;

import com.example.uis.entity.UserInfo;
import com.example.uis.request.SetInfoRequest;
import java.util.List;
import java.util.Optional;

public interface InfoService {

  List<UserInfo> getAll();

  List<UserInfo> getInfoByUserId(Long id);

  List<UserInfo> getInfoByLvlId(Long id);

  UserInfo setUserResultOnLvl(SetInfoRequest request);

  Optional<UserInfo> findUserInfoByUserIdAndLvlId(Long userId, Long lvlId);

}
