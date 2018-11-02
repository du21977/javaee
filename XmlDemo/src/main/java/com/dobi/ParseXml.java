package com.dobi;


import com.dobi.bean.Student;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/*
 *  @描述：    TODO
 */
public class ParseXml {


    public static void main(String [] args){

       // xPath();

        System.out.println(parseStudent());

    }


    //dom4j解析入门
    public static void demo(){
        try {
            //1. 构建saxreader对象
            SAXReader saxReader = new SAXReader();

            System.out.println("aaa");

            //2. 指定解析源
            // Document document =  saxReader.read(new File("heima.xml"));

            //使用类加载器来获取资源输入流

            InputStream is = ParseXml.class.getClassLoader().getResourceAsStream("heima.xml");

            Document document = saxReader.read(is);

            System.out.println("document==" + document);

            //3. 开始解析  这行代码，现在到了，<stus>
            Element rootElement = document.getRootElement();

            //获取<stus>下面的所有子标签 <stu>
            List<Element> elementList = rootElement.elements();

            //遍历出来每一个<stu> 标签
            for (Element element : elementList){


//                element.element("id")  :获取到当前标签下的孩子<id>标签  , 后面的getText() 获取id标签的文本值

                System.out.println(element.element("id").getText());
                System.out.println(element.element("name").getText());
                System.out.println(element.element("age").getText());
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }


    //xpath的语法演练
    public static void xPath(){
        try {
            //1. 构建saxreader对象
            SAXReader reader = new SAXReader();

            //2. 指定解析的数据源
            InputStream is= ParseXml.class.getClassLoader()
                    .getResourceAsStream("heima.xml");

            //3. 开始解析
            Document document = reader.read(is);


            //4. 获取stu标签
            List<Node> nodeList = document.selectNodes("//name");

            for (Node node : nodeList) {
                String text = node.getText();
                System.out.println("text=" + text);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    //解析xml,封装数据成对象，然后返回。如果对象有多个，那么使用list集合来存储。
    public static List<Student> parseStudent(){

        try {
            //1. 有对象
            SAXReader reader = new SAXReader();

            //2. 指定解析对象
            InputStream is = ParseXml.class.getClassLoader().getResourceAsStream("heima.xml");
            Document document = reader.read(is);

            List<Student> list = new ArrayList<Student>();


            //3. 解析  获取到了两个<stu>标签
            List<Node> nodeList = document.selectNodes("//stu");

            //遍历每一个stu标签  node ==><stu>
            for (Node node : nodeList) {
                Element stuElement = (Element) node;


                //获取学生标签上的no属性
                String no = stuElement.attribute("no").getValue();

                System.out.println("no===" + no);


                //1. 获取id,name,age
                String id = stuElement.element("id").getText();
                String name = stuElement.element("name").getText();
                String age = stuElement.element("age").getText();

                //构建学生对象，封装三个零散的数据
                Student student = new Student();
                student.setId(Integer.parseInt(id));
                student.setName(name);
                student.setAge(Integer.parseInt(age));


                //把学生对象存储到list集合
                list.add(student);
            }

            return list;

        } catch (DocumentException e) {
            e.printStackTrace();
        }


        return null;
    }

}
