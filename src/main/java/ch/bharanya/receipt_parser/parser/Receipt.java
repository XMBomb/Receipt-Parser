package ch.bharanya.receipt_parser.parser;

import java.util.Date;

public class Receipt {
	private Date date;
	private double totalPrice;

	public Receipt(final Date date, final double totalPrice) {
		this.date = date;
		this.totalPrice = totalPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(final double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
