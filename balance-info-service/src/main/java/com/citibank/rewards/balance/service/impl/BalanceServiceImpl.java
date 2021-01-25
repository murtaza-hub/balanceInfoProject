package com.citibank.rewards.balance.service.impl;

import java.sql.SQLException;

import com.citibank.rewards.balance.dao.BalanceDAO;
import com.citibank.rewards.balance.dao.impl.BalanceDAOImpl;
import com.citibank.rewards.balance.exception.BusinessException;
import com.citibank.rewards.balance.exception.SystemException;
import com.citibank.rewards.balance.modal.BalanceDAORequest;
import com.citibank.rewards.balance.modal.BalanceDAOResponse;
import com.citibank.rewards.balance.modal.BalanceInfo;
import com.citibank.rewards.balance.modal.BalanceRequest;
import com.citibank.rewards.balance.modal.BalanceResponse;
import com.citibank.rewards.balance.modal.StatusBlock;
import com.citibank.rewards.balance.service.BalanceService;

public class BalanceServiceImpl implements BalanceService {

	public BalanceResponse getBalance(BalanceRequest balRequest) throws BusinessException, SystemException, ClassNotFoundException, SQLException {

		// todo logic
		// convert request to daoRequest modal
		BalanceDAORequest balDAORequest = new BalanceDAORequest();
		balDAORequest.setCardNum(balRequest.getCardNum());
		balDAORequest.setClientId(balRequest.getClientId());

		// call to dao
		BalanceDAO dao = new BalanceDAOImpl();
		// get daoResponse from dao
		BalanceDAOResponse balDAOResponse = dao.getBalance(balDAORequest);
		// convert daoResp to response
		
		StatusBlock statusBlock=new StatusBlock();
		statusBlock.setRespCode(balDAOResponse.getRespCode());
		statusBlock.setRespMsg(balDAOResponse.getRespMsg());
		
		BalanceInfo balanceInfo=new BalanceInfo();
		balanceInfo.setAvailablePts(balDAOResponse.getAvailablePts());
		balanceInfo.setEarnedPts(balDAOResponse.getEarnedPts());
		balanceInfo.setPendingPts(balDAOResponse.getPendingPts());
		
		BalanceResponse response = new BalanceResponse();
		response.setStatusBlock(statusBlock);
		response.setBalanceInfo(balanceInfo);
		
		// todo logic
		return response;
	}

}
