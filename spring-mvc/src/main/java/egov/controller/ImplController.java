package egov.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImplController implements Controller{

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
    System.out.println("implController!");
    final ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("implController");
    modelAndView.addObject("msg", "implController Success!");
    return modelAndView;
  }
}
