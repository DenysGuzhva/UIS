package com.example.uis;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;
import com.example.uis.entity.UserInfo;
import com.example.uis.reposytory.DataRepository;
import com.example.uis.service.serviceImpl.InfoServiceImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InfoServiceUnitTest {

  @Mock
  private DataRepository dataRepository;

  @InjectMocks
  private InfoServiceImpl infoService;

  @Test
  public void shouldReturn20UserInfosByUserId_case1() {
    List<UserInfo> users = getUserInfosListWithTestDataCase1();
    when(dataRepository.getAllInfos()).thenReturn(users);

    List<UserInfo> resultList = infoService.getInfoByUserId(2L);

    assertEquals(20, resultList.size());

  }

  @Test
  public void shouldReturnOnlyUserInfosWithRequestedUserId_case1() {
    List<UserInfo> users = getUserInfosListWithTestDataCase1();
    when(dataRepository.getAllInfos()).thenReturn(users);

    List<UserInfo> resultList = infoService.getInfoByUserId(2L);

    assertFalse(resultList.stream().anyMatch(i -> Objects.equals(i.getUserId(), 1L)));
    assertFalse(resultList.stream().anyMatch(i -> Objects.equals(i.getUserId(), 3L)));
    assertFalse(resultList.stream().anyMatch(i -> Objects.equals(i.getUserId(), 4L)));

  }

  @Test
  public void shouldReturnUserInfosByUserIdWithTopResultValuesInDESCOrder_case1() {
    List<UserInfo> users = getUserInfosListWithTestDataCase1();
    when(dataRepository.getAllInfos()).thenReturn(users);

    List<UserInfo> resultList = infoService.getInfoByUserId(2L);

    assertEquals(30, (long) resultList.get(0).getResult());
    assertEquals(29, (long) resultList.get(1).getResult());
    assertEquals(28, (long) resultList.get(2).getResult());
    assertEquals(27, (long) resultList.get(3).getResult());
    assertEquals(26, (long) resultList.get(4).getResult());
    assertEquals(25, (long) resultList.get(5).getResult());
    assertEquals(24, (long) resultList.get(6).getResult());
    assertEquals(23, (long) resultList.get(7).getResult());
    assertEquals(22, (long) resultList.get(8).getResult());
    assertEquals(21, (long) resultList.get(9).getResult());
    assertEquals(20, (long) resultList.get(10).getResult());
    assertEquals(19, (long) resultList.get(11).getResult());
    assertEquals(18, (long) resultList.get(12).getResult());
    assertEquals(17, (long) resultList.get(13).getResult());
    assertEquals(16, (long) resultList.get(14).getResult());
    assertEquals(15, (long) resultList.get(15).getResult());
    assertEquals(14, (long) resultList.get(16).getResult());
    assertEquals(13, (long) resultList.get(17).getResult());
    assertEquals(12, (long) resultList.get(18).getResult());
    assertEquals(11, (long) resultList.get(19).getResult());

  }


  @Test
  public void shouldReturn20UserInfosByLvlId_case2() {
    List<UserInfo> users = getUserInfosListWithTestDataCase2();
    when(dataRepository.getAllInfos()).thenReturn(users);

    List<UserInfo> resultList = infoService.getInfoByLvlId(1L);

    assertEquals(20, resultList.size());

  }

  @Test
  public void shouldReturnOnlyUserInfosWithRequestedLvlId_case2() {
    List<UserInfo> users = getUserInfosListWithTestDataCase2();
    when(dataRepository.getAllInfos()).thenReturn(users);

    List<UserInfo> resultList = infoService.getInfoByLvlId(1L);

    assertFalse(resultList.stream().anyMatch(i -> Objects.equals(i.getLvlId(), 2L)));
    assertFalse(resultList.stream().anyMatch(i -> Objects.equals(i.getLvlId(), 3L)));
    assertFalse(resultList.stream().anyMatch(i -> Objects.equals(i.getLvlId(), 4L)));

  }

  @Test
  public void shouldReturnUserInfosByLvlIdWithTopResultValuesInDESCOrder_case2() {
    List<UserInfo> users = getUserInfosListWithTestDataCase2();

    when(dataRepository.getAllInfos()).thenReturn(users);

    List<UserInfo> resultList = infoService.getInfoByLvlId(1L);

    assertEquals(30, (long) resultList.get(0).getResult());
    assertEquals(29, (long) resultList.get(1).getResult());
    assertEquals(28, (long) resultList.get(2).getResult());
    assertEquals(27, (long) resultList.get(3).getResult());
    assertEquals(26, (long) resultList.get(4).getResult());
    assertEquals(25, (long) resultList.get(5).getResult());
    assertEquals(24, (long) resultList.get(6).getResult());
    assertEquals(23, (long) resultList.get(7).getResult());
    assertEquals(22, (long) resultList.get(8).getResult());
    assertEquals(21, (long) resultList.get(9).getResult());
    assertEquals(20, (long) resultList.get(10).getResult());
    assertEquals(19, (long) resultList.get(11).getResult());
    assertEquals(18, (long) resultList.get(12).getResult());
    assertEquals(17, (long) resultList.get(13).getResult());
    assertEquals(16, (long) resultList.get(14).getResult());
    assertEquals(15, (long) resultList.get(15).getResult());
    assertEquals(14, (long) resultList.get(16).getResult());
    assertEquals(13, (long) resultList.get(17).getResult());
    assertEquals(12, (long) resultList.get(18).getResult());
    assertEquals(11, (long) resultList.get(19).getResult());


  }

  @Test
  public void shouldSetNewResultForUserOnRequestedLvl() {
    List<UserInfo> users = Collections.synchronizedList(new ArrayList<>());
    users.add(new UserInfo(1L, 1L, 253L));
    users.add(new UserInfo(1L, 2L, 1L));
    users.add(new UserInfo(2L, 1L, 100L));

    when(dataRepository.getAllInfos()).thenReturn(users);

    Optional<UserInfo> userInfoByUserIdAndLvlId = infoService.findUserInfoByUserIdAndLvlId(1L, 1L);

    assertTrue(userInfoByUserIdAndLvlId.isPresent());
    assertEquals(1, (long) userInfoByUserIdAndLvlId.get().getUserId());
    assertEquals(1, (long) userInfoByUserIdAndLvlId.get().getLvlId());
    assertEquals(253, (long) userInfoByUserIdAndLvlId.get().getResult());

  }

  private List<UserInfo> getUserInfosListWithTestDataCase2() {
    List<UserInfo> users = Collections.synchronizedList(new ArrayList<>());

    for (int i = 0; i < 30; i++) {
      users.add(new UserInfo(i + 1L, 1L, i + 1L));
    }

    users.add(new UserInfo(1L, 2L, 10000L));
    users.add(new UserInfo(3L, 3L, 1L));
    users.add(new UserInfo(4L, 4L, 100L));

    return users;
  }

  private List<UserInfo> getUserInfosListWithTestDataCase1() {
    List<UserInfo> users = Collections.synchronizedList(new ArrayList<>());

    for (int i = 0; i < 30; i++) {
      users.add(new UserInfo(2L, i + 1L, i + 1L));
    }

    users.add(new UserInfo(1L, 1L, 10000L));
    users.add(new UserInfo(3L, 2L, 1L));
    users.add(new UserInfo(4L, 3L, 100L));

    return users;
  }

}
