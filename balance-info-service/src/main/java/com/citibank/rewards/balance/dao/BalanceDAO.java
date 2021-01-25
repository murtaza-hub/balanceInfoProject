package com.citibank.rewards.balance.dao;

import java.sql.SQLException;

import com.citibank.rewards.balance.exception.BusinessException;
import com.citibank.rewards.balance.exception.SystemException;
import com.citibank.rewards.balance.modal.BalanceDAORequest;
import com.citibank.rewards.balance.modal.BalanceDAOResponse;

public interface BalanceDAO {

	BalanceDAOResponse getBalance(BalanceDAORequest balDAORequest) throws BusinessException, SystemException, ClassNotFoundException, SQLException;
}
