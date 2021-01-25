package com.citibank.rewards.balance.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.citibank.rewards.balance.dao.BalanceDAO;
import com.citibank.rewards.balance.exception.BusinessException;
import com.citibank.rewards.balance.exception.SystemException;
import com.citibank.rewards.balance.modal.BalanceDAORequest;
import com.citibank.rewards.balance.modal.BalanceDAOResponse;

public class BalanceDAOImpl implements BalanceDAO {
	public BalanceDAOResponse getBalance(BalanceDAORequest balDAORequest)
			throws BusinessException, SystemException, ClassNotFoundException, SQLException {
		String PROCEDURE_QUERy = "{call getBalance(?,?,?,?)}";
		String driver = "com.mysql.cj.jdbc.Driver"; //com.mysql.cj.jdbc.Driver
		String url = "jdbc:mysql://localhost:3306/citibank";
		String user = "root";
		String password = "system";
		BalanceDAOResponse balDAOResponse = null;
		Class.forName(driver);
		
			Connection connection = DriverManager.getConnection(url, user, password);
			CallableStatement call = connection.prepareCall(PROCEDURE_QUERy);
			call.setString(1, balDAORequest.getClientId());
			call.setString(2, balDAORequest.getCardNum());

			call.registerOutParameter(3, Types.VARCHAR);
			call.registerOutParameter(4, Types.VARCHAR);
			call.execute();
			String respCode = call.getString(3);
			String respMsg = call.getNString(4);

			if (respCode.equals("000") && respMsg.equals("SUCCESS")) {
				ResultSet rs = call.executeQuery();
				while (rs.next()) {
					balDAOResponse = new BalanceDAOResponse();
					balDAOResponse.setRespCode(respCode);
					balDAOResponse.setRespMsg(respMsg);
					balDAOResponse.setAvailablePts(rs.getString(2));
					balDAOResponse.setEarnedPts(rs.getString(3));
					balDAOResponse.setPendingPts(rs.getString(4));
					return balDAOResponse;
				}
			}
			
			 else if ("101".equals(respCode) || "101".equals(respCode) || "102".equals(respCode)
						|| "103".equals(respCode)) {
					throw new BusinessException(respCode, respMsg);
				} else {
					throw new SystemException("350", "System.Error");
				}
		 
		
		return balDAOResponse;
	}

}
