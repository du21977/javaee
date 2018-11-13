package com.dobi;

import com.dobi.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        //我们自己的写法
//        UserService userService = new UserServiceImpl();
//        userService.save();

        //Spring写法----IOC-xml写法
        //1.创建工厂,并解析applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.问工厂要实例，要传递过去xml中的id
        UserService userService = (UserService) context.getBean("us");
        //3.调用方法
        userService.save();

        //Spring写法----IOC-注解写法，有id的写法
        UserService userService02 = (UserService) context.getBean("us02");
        //3.调用方法
        userService02.save();

        //Spring写法----IOC-注解写法，没有id的写法
        UserService userService03 = (UserService) context.getBean("userServiceImpl03");
        //3.调用方法
        userService03.save();


        /////////////////////////////////////DI依赖注入////////////////////////////////////
        /////////////////////////////////////DI依赖注入---xml方式////////////////////////////////////
        //DI依赖注入---XML--有参构造
        UserService userServiceDI = (UserService) context.getBean("us_DI");
        userServiceDI.save();

        //DI依赖注入---XML--set方式--一个普通成员
        UserService userServiceDISet = (UserService) context.getBean("us_DI_set");
        userServiceDISet.save();

        //DI依赖注入---XML--set方式--Array数组
        UserService userServiceDISetArray = (UserService) context.getBean("us_DI_set_array");
        userServiceDISetArray.save();

        //DI依赖注入---XML--set方式--list
        UserService userServiceDISetList = (UserService) context.getBean("us_DI_set_list");
        userServiceDISetList.save();

        //DI依赖注入---XML--set方式--map
        UserService userServiceDISetMap = (UserService) context.getBean("us_DI_set_map");
        userServiceDISetMap.save();

        //DI依赖注入---XML--set方式 -注入对象
        UserService userServiceDIObject = (UserService) context.getBean("us_DI_set_object");
        userServiceDIObject.save();

/////////////////////////////////////DI依赖注入---注解方式////////////////////////////////////
        //DI依赖注入---注解方式 -注入对象oc
        //步骤
        //1.在配置文件中设置要扫描注解的包  <context:component-scan base-package="com.dobi"></context:component-scan>
        //2.在类上打注解@Service("userServiceImplDI07")
        //3.在类成员对应的类上打注解@Repository("userDaoImpl02")
        //4.在类成员上打注解 @Resource(name = "userDaoImpl02") 或者 @Autowired  //自动注入
        //5.加载配置文件，创建工厂ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 6.问工厂要实例，传递实例对象对应类的注解id
        UserService userServiceDIObjectI = (UserService) context.getBean("userServiceImplDI07");
        userServiceDIObjectI.save();

    }

}
