package com.example.uis.reposytory;

import com.example.uis.entity.UserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class DataRepository {

  private final List<UserInfo> users = Collections.synchronizedList(new ArrayList<>());

  @PostConstruct
  private void initializeUsers() {
    long leftLimit = 10L;
    long rightLimit = 100L;

    for (int i = 0; i<=30; i++) {
      users.add(new UserInfo(1L, i + 1L, leftLimit + (long) (Math.random() * (rightLimit - leftLimit))));
    }
    for (int i = 0; i<=30; i++) {
      users.add(new UserInfo(2L, i + 1L, leftLimit + (long) (Math.random() * (rightLimit - leftLimit))));
    }
    for (int i = 0; i<=30; i++) {
      users.add(new UserInfo(3L, i + 1L, leftLimit + (long) (Math.random() * (rightLimit - leftLimit))));
    }
    for (int i = 0; i<=30; i++) {
      users.add(new UserInfo(4L, i + 1L, leftLimit + (long) (Math.random() * (rightLimit - leftLimit))));
    }

  }

  public List<UserInfo> getAllInfos() {
    return users;
  }

  public void removeInfo(UserInfo info) {
    users.remove(info);
  }

  public void addInfo(UserInfo info) {
    users.add(info);
  }

}
