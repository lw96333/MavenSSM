package com.my.test;

import org.hibernate.Session;

import com.my.entity.AccountEntity;
import com.my.entity.CreditcardEntity;
import com.my.util.HibernateUtil;

/**
 * 双向一对一关联测试
 * 
 * @author 49160
 *
 */
public class HibernateiTestOneToOne {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		
//		AccountEntity account = new AccountEntity();
//		account.setName("张三");
//		CreditcardEntity creditcardEntity = new CreditcardEntity();
//		creditcardEntity.setBank("农业银行");
//		creditcardEntity.setCarId("234234234234");
//		creditcardEntity.setAccount(account);
//		account.setCreditcard(creditcardEntity);
//		
//		session.persist(account);
//

		
		
	
		AccountEntity account = (AccountEntity) session.get(AccountEntity.class, 5);
		
//		CreditcardEntity creditcardEntity = (CreditcardEntity) session.get(CreditcardEntity.class, 6);
		
		session.delete(account);
		HibernateUtil.closeSession(session);
	}
}
