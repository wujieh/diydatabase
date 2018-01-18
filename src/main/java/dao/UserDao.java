package dao;

import model.User;
import util.ToolClass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String SPACE = " ";
    private static final String ENTER = System.getProperty("line.separator");

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
        //文件内容写入 true:追加内容,false:覆盖内容
        FileWriter out = null;
        try {
            File file1 = new File(projectPath + "\\src\\main\\resources\\database.txt");
            if (!file1.exists()) {
                file1.createNewFile();
            }
            out = new FileWriter(file1, true);
            StringBuffer sb1 = new StringBuffer();
            sb1.append(u.getMobile() + SPACE + u.getName() + SPACE + u.getSex() + SPACE + u.getEdu() + SPACE + u.getAge());
            out.write(sb1.toString());
            out.write(ENTER);
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

    public void delete(String id) {
        if (!ToolClass.isExsit(id)) {
            System.out.println("请检查输入的手机号码是否为空");
            return;
        }
        try {
            String projectPath = System.getProperty("user.dir");
            File f1 = new File(projectPath + "\\src\\main\\resources\\database.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
            List<String> l1 = new ArrayList<>();
            List<String> l2 = new ArrayList<>();
            String str1 = br.readLine();
            while (!"".equals(str1) && str1 != null) {
                l1.add(str1);
                str1 = br.readLine();
            }
            for (String str2 : l1) {
                if (str2.indexOf(id) == -1) {
                    l2.add(str2);
                }
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f1)));
            for (String str : l2) {
                bw.write(str);
                bw.newLine();
            }
            br.close();
            bw.flush();
            bw.close();
            System.out.println("删除成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("删除失败" + e.getMessage());
        } finally {
        }
    }

    public void select(String name) {
        if (!ToolClass.isExsit(name)) {
            System.out.println("请检查输入的信息是否为空");
            return;
        }
        try {
            String projectPath = System.getProperty("user.dir");
            File f1 = new File(projectPath + "\\src\\main\\resources\\database.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
            String str1 = br.readLine();
            while (str1 != null) {
                if (str1.indexOf(name) != -1) {
                    System.out.println(str1);
                }
                str1 = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
