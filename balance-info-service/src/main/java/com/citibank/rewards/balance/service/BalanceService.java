package com.citibank.rewards.balance.service;

import java.sql.SQLException;

import com.citibank.rewards.balance.exception.BusinessException;
import com.citibank.rewards.balance.exception.SystemException;
import com.citibank.rewards.balance.modal.BalanceRequest;
import com.citibank.rewards.balance.modal.BalanceResponse;

public interface BalanceService {

	BalanceResponse getBalance(BalanceRequest balRequest) throws BusinessException, SystemException, ClassNotFoundException, SQLException;

}
