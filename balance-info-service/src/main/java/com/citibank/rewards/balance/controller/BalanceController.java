package com.citibank.rewards.balance.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citibank.rewards.balance.exception.BalanceRequestInvalidDataException;
import com.citibank.rewards.balance.exception.BusinessException;
import com.citibank.rewards.balance.exception.SystemException;
import com.citibank.rewards.balance.modal.BalanceRequest;
import com.citibank.rewards.balance.modal.BalanceResponse;
import com.citibank.rewards.balance.service.BalanceService;
import com.citibank.rewards.balance.service.impl.BalanceServiceImpl;
import com.citibank.rewards.balance.validator.BalanceValidator;

@RestController
public class BalanceController {

	 // @GetMapping(value = "/balance/{cardNum}", produces = "application/json")
	@RequestMapping(method = RequestMethod.GET,value = "balance/{cardNum}", produces = "application/json")  
	public BalanceResponse getBalance(@PathVariable("cardNum") String cardNum,
			  							@RequestHeader(value = "client-Id", required=false) String clientId,
			  							@RequestHeader(value = "request-Id",required=false) String requestId,
			  							@RequestHeader("msg-ts") String msgts) throws BalanceRequestInvalidDataException, BusinessException, SystemException, ClassNotFoundException, SQLException {
	
		 // prepared request // get request	 
	  
	  BalanceRequest balRequest = new BalanceRequest();
	  balRequest.setCardNum(cardNum);
	  balRequest.setClientId(clientId);	  
	  balRequest.setRequestId(requestId);
	  balRequest.setMsgts(msgts);
	 
		
		// validate the request
		BalanceValidator validator = new BalanceValidator();
		validator.validateRequest(balRequest);

		// call to service
		BalanceService service = new BalanceServiceImpl();
		BalanceResponse balResponse = service.getBalance(balRequest);
		return balResponse;
	}	
}
