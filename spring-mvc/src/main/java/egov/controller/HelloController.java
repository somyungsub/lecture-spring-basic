package egov.controller;

import egov.service.UserService;
import egov.vo.DeptVO;
import egov.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(value = {"sessionUser", "sessionUser2"})
public class HelloController {


  @ModelAttribute("stringList")
  public List<String> referenceStringList() {
    return Arrays.asList("a", "B", "C1", "dd", "aasda");
  }


  @ModelAttribute("stringList2")
  public List<String> referenceStringList2() {
    return Arrays.asList("a", "B", "C1", "dd");
  }

  @RequestMapping(path = "/hello.do", method = RequestMethod.POST)
  public String helloPost(Model model) {
    System.out.println("hello Post");
    model.addAttribute("msg", "Hello Success POST");
    return "hello";
  }

  @RequestMapping(value = "/hello.do", method = RequestMethod.GET)
  public String helloGet(Model model) {
    System.out.println("hello Get");
    UserVO vo = new UserVO();
    vo.setId("123");
    vo.setName("soso");
    vo.setPassword("password123~");
    model.addAttribute("user", vo);
    model.addAttribute("msg", "Hello Success GET");
    return "hello";
  }

  @RequestMapping(value = "/helloRequestParam.do", method = RequestMethod.GET)
  public String helloParam(@RequestParam(value = "msg", required = false, defaultValue = "None") String msg
      , @RequestParam(value = "msg2", required = false) String msg2
      , Model model) {
    System.out.println("hello Request msg : " + msg);
    System.out.println("hello Request msg2 : " + msg2);
    model.addAttribute("msg", msg);
    model.addAttribute("msg2", msg2);
    return "hello";
  }

  @RequestMapping(value = "/helloRequestParamDefault.do", method = RequestMethod.GET)
  public String helloModelAttribute(String id, String name, @RequestParam String password) {
    System.out.println("id = " + id);
    System.out.println("name = " + name);
    System.out.println("password = " + password);
    return "hello";
  }

  @RequestMapping(value = "/helloModelAttributeParam.do", method = RequestMethod.GET)
  public String helloModelAttributeParam(@ModelAttribute("user") UserVO user) {
    System.out.println("user = " + user);
    return "hello";
  }

  @RequestMapping(value = "/helloModelAttributeSkip.do", method = RequestMethod.GET)
  public ModelAndView helloModelAttributeSkip(UserVO user) {
    System.out.println("user = " + user);
    ModelAndView mav = new ModelAndView("hello").addObject("user", user);
    return mav;
  }

  @RequestMapping(value = "/helloModelAttributeDefault.do", method = RequestMethod.GET)
  public String helloModelAttributeDefault(UserVO userVO, UserVO user, String id) {
    System.out.println("userVO = " + userVO);
    System.out.println("user = " + user);
    System.out.println("id = " + id);
    return "hello";
  }

  @RequestMapping(value = "/helloModelAttributeDefault2.do", method = RequestMethod.GET)
  public String helloModelAttributeDefault2(UserVO userVO, UserVO user, String id, DeptVO dept) {
    System.out.println("userVO = " + userVO);
    System.out.println("user = " + user);
    System.out.println("dept = " + dept);
    System.out.println("id = " + id);
    return "hello";
  }

  @RequestMapping(value = "/helloSession.do", method = RequestMethod.GET)
  public String helloSession(Model model) {
    System.out.println("helloSession.do~");
    UserVO userVO = new UserVO();
    userVO.setId("100");
    userVO.setName("soSession");
    userVO.setPassword("sessison!234a");
    model.addAttribute("sessionUser", userVO);
    return "hello";
  }

  @RequestMapping(value = "/helloSessionUpdate.do", method = RequestMethod.GET)
  public String helloSessionUpdate(@ModelAttribute("sessionUser") UserVO userVO) {
    System.out.println("userVO = " + userVO);
    return "hello";
  }

  @RequestMapping(value = "/helloSessionLogOut.do", method = RequestMethod.GET)
  public String helloSessionLogOut(SessionStatus status) {
    System.out.println("세션종료");
    if (!status.isComplete()) {
      System.out.println("세션종료 완료");
      status.setComplete(); // 세션종료
    }
    return "redirect:/";
  }

  @RequestMapping(value = "/helloReturnMap.do", method = RequestMethod.GET)
  public Map<String, Object> helloReturnMap(HttpServletRequest request) {
    System.out.println("Return Map");
    Map<String, Object> map = new HashMap<>();
    map.put("user", request.getSession().getAttribute("sessionUser"));
    map.put("msg", "메시지 리턴 Map 1");
    map.put("msg2", "메시지 리턴 Map 2");
    return map;
  }

  @RequestMapping(value = "/helloReturnMav.do", method = RequestMethod.GET)
  public ModelAndView helloReturnModelAndView(UserVO user) {
    System.out.println("Return ModelAndView ~! ");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("helloReturnMav");
    mav.addObject("msg", "메시지 리턴 ModelAndView 1");
    mav.addObject("msg2", "메시지 리턴 ModelAndView 2");
    mav.addObject("user", user);
    return mav;
  }

  @RequestMapping(value = "/helloReturnVoid.do", method = RequestMethod.GET)
  public void helloReturnVoid(UserVO user, Model model) {
    model.addAttribute("msg", "메시지 리턴 Void 1");
    model.addAttribute("msg2", "메시지 리턴 Void 2");
    System.out.println("Return Void, user = " + user);
  }

  @RequestMapping(value = "/helloReturnVO.do", method = RequestMethod.GET)
  public UserVO helloReturnObject(UserVO user, Model model) {
    model.addAttribute("msg", "메시지 리턴 VO 1");
    model.addAttribute("msg2", "메시지 리턴 VO 2");
    System.out.println("Return VO, user = " + user);
    return new UserVO("10", "객체 생성 후 반환", "1234");
//    return user;
  }

  @RequestMapping(value = "/practice.do")
  public String practice() {
    return "practice/practice";
  }

  @RequestMapping(value = "/helloError.do", method = RequestMethod.GET)
  public String helloError(String id) {

    System.out.println("Error~");
    if (id == null || id.isEmpty()) {
      throw new NullPointerException("널포인터 예외!");
    }
    return "hello";
  }

  // Exception 핸들
  @ExceptionHandler(Exception.class)
  public ModelAndView handlerException(Exception e) {
    return new ModelAndView("error").addObject("msg", e.getMessage());
  }

}
