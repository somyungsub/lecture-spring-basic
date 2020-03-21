package egov.com;

import javax.servlet.*;
import java.io.IOException;

public class FilterTest implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    System.out.println("================ 요청 ================");
    System.out.println("test Filter 전");
    filterChain.doFilter(servletRequest, servletResponse);
    System.out.println("test Filter 후");
  }

  @Override
  public void destroy() {

  }
}
