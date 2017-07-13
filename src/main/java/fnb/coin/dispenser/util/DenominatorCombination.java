package fnb.coin.dispenser.util;

public class DenominatorCombination {
	private Denominator denominator;
	private Integer frequency;
	
	public DenominatorCombination(Denominator denominator, Integer frequency) {
		this.denominator = denominator;
		this.frequency = frequency;
	}
	public Denominator getDenominator() {
		return denominator;
	}
	public void setDenominator(Denominator denominator) {
		this.denominator = denominator;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	@Override
	public String toString() {
		return "DenominatorCombination [denominator=" + denominator + ", value ="+denominator.getValue()+ ", frequency=" + frequency + "]";
	}
}
