package ch.bharanya.receipt_parser.parser.migros;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import ch.bharanya.receipt_parser.parser.Receipt;

public class MigrosReceipt extends Receipt
{
	private List<MigrosReceiptElement> receiptElements = new ArrayList<>();
	private String location;
	private int checkOutNumber;
	private double cumulusPoints;
	private long transactionNumber;

	public MigrosReceipt ( final List<MigrosReceiptElement> receiptElements )
	{
		this.receiptElements = receiptElements;
	}

	public MigrosReceipt ()
	{
		super();
	}

	@Override
	public double getTotalPrice ()
	{
		if ( receiptElements.size() > 0 )
		{
			// TODO: discount?
			return receiptElements.stream().mapToDouble( receipt -> receipt.getPrice() ).sum();
		}
		return super.getTotalPrice();
	}

	@Override
	public String getId ()
	{
		return String.valueOf( getTransactionNumber() );
	}

	public String getLocation ()
	{
		if ( receiptElements.size() > 0 )
		{
			return receiptElements.stream().filter( receipt -> StringUtils.isNotBlank( receipt.getStoreName() ) )
					.collect( Collectors.toList() ).get( 0 ).getStoreName();
		}
		return location;
	}

	/**
	 * @param receiptElements
	 *            the receiptElements to set
	 */
	public void setReceiptElements ( final List<MigrosReceiptElement> receiptElements )
	{
		this.receiptElements = receiptElements;
	}

	/**
	 * @return the checkOutNumber
	 */
	public int getCheckOutNumber ()
	{
		return checkOutNumber;
	}

	/**
	 * @param checkOutNumber
	 *            the checkOutNumber to set
	 */
	public void setCheckOutNumber ( final int checkOutNumber )
	{
		this.checkOutNumber = checkOutNumber;
	}

	/**
	 * @return the cumulusPoints
	 */
	public double getCumulusPoints ()
	{
		return cumulusPoints;
	}

	/**
	 * @param cumulusPoints
	 *            the cumulusPoints to set
	 */
	public void setCumulusPoints ( final double cumulusPoints )
	{
		this.cumulusPoints = cumulusPoints;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation ( final String location )
	{
		this.location = location;
	}

	public long getTransactionNumber ()
	{
		return transactionNumber;
	}

	public void setTransactionNumber ( final long transactionNumber )
	{
		// nicer for debugging :)
		setId(String.valueOf(transactionNumber));
		this.transactionNumber = transactionNumber;
	}

}
