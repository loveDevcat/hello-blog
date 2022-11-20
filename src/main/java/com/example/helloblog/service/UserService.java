package com.example.helloblog.service;

import com.example.helloblog.domain.Blog;
import com.example.helloblog.domain.User;

public interface UserService {
    User loginService(String uname, String password);
    User registService(String uname, String password);


}
