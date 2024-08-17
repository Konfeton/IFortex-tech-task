package com.example.techtask.service.impl;

import com.example.techtask.model.User;
import com.example.techtask.repository.UserRepository;
import com.example.techtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUser() {
        //1. Возвращать пользователя с максимальной общей суммой товаров, доставленных в 2003.
        User user = userRepository.findUserWithMaxTotalPrice();
        return user;
    }

    @Override
    public List<User> findUsers() {
        //2. Возвращать пользователей у которых есть оплаченные заказы в 2010.
        List<User> users = userRepository.findUsersWithPaidOrder();
        return users;
    }
}
