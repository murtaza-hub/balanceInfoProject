package com.citibank.rewards.balance.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.citibank.rewards.balance.exception.BalanceRequestInvalidDataException;
import com.citibank.rewards.balance.exception.BusinessException;
import com.citibank.rewards.balance.exception.SystemException;
import com.citibank.rewards.balance.modal.BalanceResponse;
import com.citibank.rewards.balance.modal.StatusBlock;

@RestControllerAdvice
public class BalanceExceptionHandler {

	@ExceptionHandler(value = BalanceRequestInvalidDataException.class)
	public BalanceResponse handleBalanceInvalidException(BalanceRequestInvalidDataException exception) {
		StatusBlock statusBlock = new StatusBlock();
		BalanceResponse balResponse = new BalanceResponse();
		statusBlock.setRespCode(exception.getRespCode());
		statusBlock.setRespMsg(exception.getRespMsg());
		balResponse.setStatusBlock(statusBlock);

		exception.printStackTrace();
		return balResponse;

	}

	@ExceptionHandler(value = BusinessException.class)
	public BalanceResponse handleBalanceInvalidException(BusinessException exception) {
		StatusBlock statusBlock = new StatusBlock();
		BalanceResponse balResponse = new BalanceResponse();
		statusBlock.setRespCode(exception.getRespCode());
		statusBlock.setRespMsg(exception.getRespMsg());
		balResponse.setStatusBlock(statusBlock);

		exception.printStackTrace();
		return balResponse;

	}

	@ExceptionHandler(value = SystemException.class)
	public BalanceResponse handleBalanceInvalidException(SystemException exception) {
		StatusBlock statusBlock = new StatusBlock();
		BalanceResponse balResponse = new BalanceResponse();
		statusBlock.setRespCode(exception.getRespCode());
		statusBlock.setRespMsg(exception.getRespMsg());
		balResponse.setStatusBlock(statusBlock);

		exception.printStackTrace();
		return balResponse;

	}

	@ExceptionHandler(value = Exception.class)
	public BalanceResponse handleBalanceInvalidException(Exception exception) {
		StatusBlock statusBlock = new StatusBlock();
		BalanceResponse balResponse = new BalanceResponse();
		statusBlock.setRespCode("2222");
		statusBlock.setRespMsg("Unknow exception");
		balResponse.setStatusBlock(statusBlock);

		exception.printStackTrace();
		return balResponse;

	}

}
