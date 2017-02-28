package com.cdc.transaction.ui.handler.impl;

import com.cdc.transaction.ui.dialog.TransferTransactionDialog;
import com.cdc.transaction.ui.handler.UserSelectHandler;

public class TransferUserSelectHandler implements UserSelectHandler {
	//转发事务的处理窗口
	private TransferTransactionDialog dialog;
	public TransferUserSelectHandler(TransferTransactionDialog dialog) {
		this.dialog = dialog;
	}
	public void confirm(String userId, String realName) {
		this.dialog.getUserIdText().setText(userId);
		this.dialog.getRealNameText().setText(realName);
	}
}
