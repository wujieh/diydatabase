package dao;

import model.User;
import util.ToolClass;

import java.io.*;

public class UserDao {
    private static final String SPACE = " ";
    private static final String ENTER = "/r/n";

    public void save(User u) {
        if (!ToolClass.isExsit(u.getAge())) {
            System.out.println("用户年龄不能为空");
            return;
        }
        if (!ToolClass.isExsit(u.getEdu())) {
            System.out.println("用户学历不能为空");
            return;
        }
        if (!ToolClass.isExsit(u.getMobile())) {
            System.out.println("用户手机号码不能为空");
            return;
        }
        if (!ToolClass.isExsit(u.getName())) {
            System.out.println("用户姓名不能为空");
            return;
        }
        if (!ToolClass.isExsit(u.getSex())) {
            System.out.println("用户性别不能为空");
            return;
        }
        String projectPath = System.getProperty("user.dir");
        BufferedWriter out = null;
        try {
            File file1 = new File(projectPath + "\\src\\main\\resources\\database.txt");
            if (!file1.exists()) {
                file1.createNewFile();
            }
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1)));
            StringBuffer sb1 = new StringBuffer();
            sb1.append(u.getMobile() + SPACE + u.getName() + SPACE + u.getSex() + SPACE + u.getEdu() + SPACE + u.getAge());
            out.newLine();
            out.write(sb1.toString());
            out.flush();
            System.out.println("=============保存成功=============");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("====================操作失败========================" + e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
