package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext5.xml")
public class SpringDemo2 {
    
    /**
     * 注入代理类
     */
    @Resource(name="accountServiceProxy")
    private AccountService accountService;
    
    @Test
    public void demo(){
        accountService.transfer("aaa", "bbb", 200d);
    }
}