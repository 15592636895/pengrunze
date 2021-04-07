package com.example.myapplication.dao;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.myapplication.entity.User;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class UserDaoTest extends TestCase {
    Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    UserDao userDao=new UserDao(appContext);
    @Test
    public void testAddUser() {
        User  user=new User();
        user.setGender("male");
        user.setPwd("123");
        user.setName("ppp");
        userDao.addUser(user);
}
}