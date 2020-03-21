package egov.aop.proxy;

import egov.aop.UserVO;

public interface SuperService {

  void insert(UserVO userVO);

  void delete(UserVO userVO);

  UserVO selectOne(String id);

}
