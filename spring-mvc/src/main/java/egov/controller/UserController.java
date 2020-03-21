package egov.controller;

import egov.service.UserService;
import egov.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/setupData.do", method = RequestMethod.POST)
  public String setUpData() {
    userService.deleteAll();
    userService.insertUserBatch(Arrays.asList(
        new UserVO("10", "name10", "pass10")
        , new UserVO("11", "name11", "pass11")
        , new UserVO("12", "name12", "pass12")
    ));
    System.out.println("초기 데이터 로딩 완료!");
    return "redirect:/";
  }

  // 단건조회
  @RequestMapping(value = "/selectUserOne.do", method = RequestMethod.POST)
  public String selectUserOne(Model model, String id) {
    model.addAttribute("msg","select User One !!");

    // TODO 실습 : 화면에 출력할 모델 설정 (view : user/selectOne.jsp)
    // model key : user
    model.addAttribute("user", userService.selectOne(id));
    return "user/selectOne";
  }

  // 다건조회
  @RequestMapping(value = "/selectUserList.do")
  public String selectUserList(Model model) {
    model.addAttribute("msg","select User List !!");

    // TODO 실습 : 화면에 출력할 모델 설정 (view : user/userList.jsp)
    // model key : userList
    model.addAttribute("userList", userService.selectList());
    return "user/userList";
  }

  // 추가
  @RequestMapping(value = "/insertView.do", method = RequestMethod.POST)
  public String insertView(@ModelAttribute UserVO userVO) {
    System.out.println(userVO);
    return "user/insertView";
  }

  @RequestMapping(value = "/insertUser.do", method = RequestMethod.POST)
  public String insertUser(@ModelAttribute UserVO userVO) {
    System.out.println("userVO = " + userVO);

    // TODO 실습 : userVO 추가
    userService.insert(userVO);
    return "redirect:/user/selectUserList.do";
  }

  // 수정
  @RequestMapping(value = "/updateView.do", method = RequestMethod.POST)
  public String updateView(@ModelAttribute UserVO userVO) {
    System.out.println("userVO = " + userVO);
    return "user/updateView";
  }
  @RequestMapping(value = "/updateUser.do", method = RequestMethod.POST)
  public String updateUser(@ModelAttribute UserVO userVO) {
    System.out.println("userVO = " + userVO);

    // TODO 실습 : id 값에 해당하는 user 수정
    userService.update(userVO);
    return "redirect:/user/selectUserList.do";
  }

  // 삭제
  @RequestMapping(value = "/deleteUser.do", method = RequestMethod.POST)
  public String deleteUser(String id) {
    System.out.println("id = " + id);

    // TODO 실습 : id 값에 해당하는 user 삭제
    userService.delete(id);
    return "redirect:selectUserList.do";
  }



  /*
    번외
    - PathVariable
    - ExceptionHandler
   */
  // PathVariable 예제
 @RequestMapping(value = "/selectUserOne/{id}")
  public String selectUserOnePathValue(Model model, @PathVariable("id") int id) {
    model.addAttribute("msg","select User One PathValue 방식!!");
    System.out.println("id = " + id);
    System.out.println("userService.selectOne(id) = " + userService.selectOne(String.valueOf(id)));
    model.addAttribute("user", userService.selectOne(String.valueOf(id)));
    return "user/selectOne";
  }

  // Exception 처리
  @ExceptionHandler(Exception.class)
  public ModelAndView handlerException(Exception e) {
    return new ModelAndView("error").addObject("msg", e.getMessage());
  }

}
