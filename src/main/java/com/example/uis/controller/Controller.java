package com.example.uis.controller;

import com.example.uis.entity.UserInfo;
import com.example.uis.request.SetInfoRequest;
import com.example.uis.service.serviceImpl.InfoServiceImpl;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info")
public class Controller {

  private final InfoServiceImpl infoService;

  public Controller(InfoServiceImpl infoService) {
    this.infoService = infoService;
  }

  @GetMapping("/all")
  public List<UserInfo> getAllInfos() {
    return infoService.getAll();
  }

  @GetMapping("/user/{id}")
  public List<UserInfo> getUserInfo(@PathVariable("id") Long id) {
    return infoService.getInfoByUserId(id);
  }

  @GetMapping("/level/{id}")
  public List<UserInfo> getLvlInfo(@PathVariable(name = "id") Long id) {
    return infoService.getInfoByLvlId(id);
  }

  @PutMapping("/set")
  public UserInfo setResult(@RequestBody SetInfoRequest request) {
    return infoService.setUserResultOnLvl(request);
  }

}
