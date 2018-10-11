package test;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


public class AccountServiceImpl implements AccountService {
    //注入DAO类
    private AccountDao accountDao;

    //注入事务管理模板
//    private TransactionTemplate transactionTemplate;


//    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
//        this.transactionTemplate = transactionTemplate;
//    }
    

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    /**
     *
     * @param out   :转出账号
     * @param in    ：转入账号
     * @param money ：转账金额
     *              声明式事物：分为1：基于AspectJ的XML方式
     *                              2：基于TransactionProxyFactoryBean的方式
     *                              3：基于注解的方式
     */

    @Override
    @Transactional
    public void transfer(String out, String in, Double money) {
        accountDao.outMoney(out, money);
//        int i = 1/0;
        accountDao.inMoney(in, money);
    }



/*    //编程时事物
    @Override
    public void transfer(String out, String in, Double money) {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.outMoney(out, money);
//                int i = 1/0;
                accountDao.inMoney(in, money);
            }
        });
    }*/



}
