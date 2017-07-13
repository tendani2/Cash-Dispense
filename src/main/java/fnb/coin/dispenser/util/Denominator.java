package fnb.coin.dispenser.util;

import java.math.BigDecimal;

public enum Denominator {
	ONE_HUNDRED_RAND("One hundred rand", new BigDecimal("100.00")),
	FIFTY_RAND("Fifty rand", new BigDecimal("50.00")),
	TWENTY_RAND("Twenty rand", new BigDecimal("20.00")),
	TEN_RAND("Ten rand", new BigDecimal("10.00")),
	FIVE_RAND("Five rand", new BigDecimal("5.00")),
	TWO_RAND("Two rand", new BigDecimal("2.00")),
	ONE_RAND("One rand", new BigDecimal("1.00")),
	FIFTY_CENTS("Fifty cents", new BigDecimal("0.50")),
	TWENTY_FIVE_CENTS("Twenty five cents", new BigDecimal("0.25")),
	TEN_CENTS("Ten cents", new BigDecimal("0.10")),
	FIVE_CENTS("Five cents", new BigDecimal("0.05"));
	
	private String name;
	private BigDecimal value;
	
	Denominator(String name, BigDecimal value){
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
}
