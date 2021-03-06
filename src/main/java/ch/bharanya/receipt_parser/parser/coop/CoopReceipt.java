package ch.bharanya.receipt_parser.parser.coop;

import java.util.Date;

import ch.bharanya.receipt_parser.parser.EStore;
import ch.bharanya.receipt_parser.parser.Receipt;

public class CoopReceipt extends Receipt {
	private final EStore store = EStore.COOP;
	private String location;

	public CoopReceipt(final String id, final Date date, final double totalPrice) {
		super(id, date, totalPrice);
	}

	public CoopReceipt(final String id, final Date date, final double totalPrice, final String location) {
		super(id, date, totalPrice);
		setLocation(location);
	}

	@Override
	public EStore getStore() {
		return store;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(final String location) {
		this.location = location;
	}

}
