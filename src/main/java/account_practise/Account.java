package account_practise;

import java.math.BigDecimal;

public class Account {
	private int acc_id;
	private String bank;
	private String acc_name;
	private BigDecimal amount;
	private String update_date;
	
	public Account(int acc_id,String bank,String acc_name,BigDecimal amount,String update_date) {
		this.acc_id=acc_id;
		this.bank=bank;
		this.acc_name=acc_name;
		this.amount=amount;
		this.update_date=update_date;
	}
	public int getAcc_id(){
		return acc_id;
	}
	public String getBank() {
		return bank;
	}
	public String getAcc_name() {
		return acc_name;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public String getUpdate_date() {
		return update_date;
	}
	
}
