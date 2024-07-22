package com.kajarta.security.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface EmployeeDetailsService {

    /**
     * 加載用戶詳情
     *
     * @param username 登入用戶名
     * @return 用戶詳情
     */
    UserDetails loadUserByUsername(String username);

}
