package web;

import dao.UserDao;
import model.User;

import java.io.InputStream;
import java.util.Scanner;

//user web层负责逻辑业务处理
public class UserWeb {
    public void saveUser(){
        //System.out.println("请依次输入手机号、用户名、年龄、性别,教育经历请使用单个空格分割");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        User u = new User();
        u.setMobile(strs[0]);
        u.setAge(strs[3]);
        u.setEdu(strs[4]);
        u.setName(strs[1]);
        u.setSex(strs[2]);
        UserDao userDao = new UserDao();
        userDao.save(u);
    }

    public void deleteUserById() {
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao();
        userDao.delete(scanner.nextLine().trim());
    }

    public void selectUser() {
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao();
        userDao.select(scanner.nextLine().trim());
    }
}
