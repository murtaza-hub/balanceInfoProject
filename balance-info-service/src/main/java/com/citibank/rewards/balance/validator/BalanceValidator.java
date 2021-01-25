package com.citibank.rewards.balance.validator;

import com.citibank.rewards.balance.exception.BalanceRequestInvalidDataException;
import com.citibank.rewards.balance.modal.BalanceRequest;

public class BalanceValidator {

	public void validateRequest(BalanceRequest balReq) throws BalanceRequestInvalidDataException {
		if (balReq.getCardNum() == null || "".equals(balReq.getCardNum()) || "".equals(balReq.getCardNum().toString().trim())) {
			throw new BalanceRequestInvalidDataException("bal00", "invalid Card-Num");
		}
		if (balReq.getClientId() == null || "".equals(balReq.getClientId()) || " ".equals(balReq.getClientId().toString().trim())) {
			throw new BalanceRequestInvalidDataException("bal01", "invalid Client-Id");
		}
		if (balReq.getRequestId() == null || "".equals(balReq.getRequestId()) || " ".equals(balReq.getRequestId().toString().trim())) {
			throw new BalanceRequestInvalidDataException("bal02", "invalid Request-Id");
		}
	}
}
