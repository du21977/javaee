package com.dobi;


import com.dobi.transaction.xml_annotation.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用Junit单元测试：测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:transaction_annotation.xml")
public class TransactionAnnotationAccountServiceTest {

    @Autowired
    private IAccountService as1;

    @Test
    public  void testTransfer(){
        as1.transfer("aaa","bbb",60f);

    }

}
