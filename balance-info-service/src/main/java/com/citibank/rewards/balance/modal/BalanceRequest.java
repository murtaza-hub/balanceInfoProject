package com.citibank.rewards.balance.modal;

import lombok.Data;

@Data
public class BalanceRequest {
	
	private String cardNum;
	private String clientId;
	private String requestId;
	private String msgts;

}
