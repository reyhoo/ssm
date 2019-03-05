package com.yl.springmvc.validate.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.yl.springmvc.validate.pojo.Transaction;

public class TransactionValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Transaction.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Transaction transaction = (Transaction) arg0;
		double dis = transaction.getAmount() - (transaction.getPrice() * transaction.getQuantity());
		if(Math.abs(dis)>0.01d) {
			arg1.rejectValue("amount", null,"交易金额和购买数据与价格不匹配");
		}
	}

}
