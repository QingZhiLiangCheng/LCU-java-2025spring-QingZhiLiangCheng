package cn.edu.lcu.cs.basic.program_principle.dip;

import java.util.List;

public interface UserService {
    boolean login(String username, String password);

    List<User> findAll();

    User findById(Long id);
}
