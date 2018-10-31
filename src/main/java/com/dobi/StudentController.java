package com.dobi;

import com.dobi.bean.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * 用文件存数据来模仿数据库的增删改查
 */
@RestController
public class StudentController {

    private int id = 1;//学生编号递增

    //添加学生
    @RequestMapping("/student/save")
    public String save(Student student){

        try {
            System.out.println("save----"+student);
            FileWriter fileWriter = new FileWriter("stu.txt",true);
            fileWriter.write(id+"#"+student.toString());
            fileWriter.close();
            id++;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "添加成功";
    }

    //删除学生操作
    //1.读出所有的学生
    //2,。遍历匹配要删除的学生
    //3.拼接没有被删除的学生
    //写入文件
    @RequestMapping("/student/delete")
    public String delete(String id){


        try {
            System.out.println("delete"+id);
            FileReader fileReader = new FileReader("stu.txt");//这个不能读取一行，得用BufferReader
            BufferedReader br = new BufferedReader(fileReader);

            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line =br.readLine())!=null){  //读取一行的东西不为空
                System.out.println("line="+line);

                //切割取出id
                String sid = line.split("#")[0];
                //不相等就拼接
                if(!sid.equals(id)){
                    stringBuilder.append(line+"\r\n");

                }


            }
            System.out.println(stringBuilder.toString());
            FileWriter fileWriter = new FileWriter("stu.txt");
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return "删除成功";
    }


    /**
     * 改操作
     * @param id
     * @param age
     * @return
     */
    @RequestMapping("/student/update")
    public String update(String id ,int age){
        try {
            BufferedReader br = new BufferedReader(new FileReader("stu.txt"));

            String line =null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line=br.readLine())!=null){
                String[] array = line.split("#");
                String sid = array[0];
                if(sid.equals(id)){
                    //找到了
                    line = array[0]+"#"+array[1]+"#"+age+"#"+array[2];
                }
                    stringBuilder.append(line+"\r\n");

            }
            //写入文件
            System.out.println(stringBuilder.toString());
            FileWriter fileWriter = new FileWriter("stu.txt");
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "更新成功";
    }


    @RequestMapping("/student/findall")
    public String update(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("stu.txt"));

            String line =null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line=br.readLine())!=null){
                stringBuilder.append(line+"\r\n");

            }
            System.out.println("all--\r\n"+stringBuilder);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "查询成功";
    }
}
