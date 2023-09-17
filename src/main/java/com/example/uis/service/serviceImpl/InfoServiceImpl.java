package com.example.uis.service.serviceImpl;

import com.example.uis.reposytory.DataRepository;
import com.example.uis.entity.UserInfo;
import com.example.uis.request.SetInfoRequest;
import com.example.uis.service.InfoService;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InfoServiceImpl implements InfoService {

  private final DataRepository dataRepository;

  @Override
  public List<UserInfo> getAll() {
    return dataRepository.getAllInfos();
  }

  @Override
  public List<UserInfo> getInfoByUserId(Long id) {
    return dataRepository.getAllInfos()
        .stream().filter(Objects::nonNull)
        .filter(i -> Objects.equals(i.getUserId(), id))
        .sorted(Comparator.comparingLong(UserInfo::getResult).reversed())
        .limit(20)
        .collect(Collectors.toList());
  }

  @Override
  public List<UserInfo> getInfoByLvlId(Long id) {
    return dataRepository.getAllInfos()
        .stream().filter(Objects::nonNull)
        .filter(i -> Objects.equals(i.getLvlId(), id))
        .sorted(Comparator.comparingLong(UserInfo::getResult).reversed())
        .limit(20)
        .collect(Collectors.toList());
  }

  @Override
  public UserInfo setUserResultOnLvl(SetInfoRequest request) {
    Optional<UserInfo> info = findUserInfoByUserIdAndLvlId(request.getUserId(), request.getLvlId());
    info.ifPresent(dataRepository::removeInfo);
    return addToListAndReturn(request);

  }

  @Override
  public Optional<UserInfo> findUserInfoByUserIdAndLvlId(Long userId, Long lvlId) {
    return dataRepository.getAllInfos()
        .stream().filter(Objects::nonNull)
        .filter(i -> Objects.equals(i.getUserId(), userId))
        .filter(i -> Objects.equals(i.getLvlId(), lvlId))
        .findFirst();
  }

  private UserInfo addToListAndReturn(SetInfoRequest request) {
    UserInfo infoFromRequest = new UserInfo(request.getUserId(), request.getLvlId(), request.getResult());
    dataRepository.addInfo(infoFromRequest);
    return infoFromRequest;
  }
}
