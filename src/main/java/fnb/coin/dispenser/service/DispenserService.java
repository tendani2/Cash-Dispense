package fnb.coin.dispenser.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import fnb.coin.dispenser.util.Denominator;
import fnb.coin.dispenser.util.DenominatorCombination;

/**
 * CoinDispenserService
 * 
 * @author tendani
 *
 */
public class DispenserService {
	// Denominator hash map.
	private Map<Denominator, Integer> denominatorMap;
	private Denominator[] denominator;
	private Map<Denominator, DenominatorCombination> denominatorFrequencyMap;
	private Logger LOGGER = Logger.getLogger(DispenserService.class);

	public DispenserService() { this.init(); }

	/**
	 * Initializes variables.
	 */
	private void init() {
		LOGGER.debug("------------ Enter init of variables.");
		// Initialize denominator map.
		this.denominatorMap = new HashMap<Denominator, Integer>();
		// Initialize denominator frequency map. Will store denominator and frequency.
		this.denominatorFrequencyMap = new HashMap<>();
		
		// Load available denominations.
		Denominator[] denominator = {Denominator.ONE_HUNDRED_RAND, 
									Denominator.FIFTY_RAND, 
									Denominator.TWENTY_RAND,
									Denominator.TEN_RAND, 
									Denominator.FIVE_RAND, 
									Denominator.TWO_RAND, 
									Denominator.ONE_RAND,
									Denominator.FIFTY_CENTS, 
									Denominator.TWENTY_FIVE_CENTS, 
									Denominator.TEN_CENTS, 
									Denominator.FIVE_CENTS };

		this.denominator = denominator;
		LOGGER.debug("------------ Loaded denominations :::."+ this.denominator.toString());
		
		// load denominators and their default units.
		for (Denominator denom : denominator) {
			this.denominatorMap.put(denom, 0);
		}
		
		LOGGER.debug("Denominator map size = "+ this.denominatorMap.size());
	}
	
	/**
	 * @param amount
	 * @return Map<Denominator, DenominatorCombination>
	 */
	public Map<Denominator, DenominatorCombination> dispense(BigDecimal amount) {
		int freq = 0;
		for (Denominator den : denominator) {
			if (amount.compareTo(den.getValue()) >= 0) {
				// Entered for the first time.
				freq = updateFrequency(freq, den);
				// Calculate remainder.
				amount = calculateRemainder(amount, den);
			}
		}
		LOGGER.debug("Map values :::: "+denominatorFrequencyMap.toString());
		
		return this.denominatorFrequencyMap;

	}
	/**
	 * Updates frequency of denominations.
	 * @param freq
	 * @param moneyType
	 * @return Integer
	 */
	private Integer updateFrequency(int freq, Denominator moneyType) {
		if(freq == 0){
			this.denominatorFrequencyMap.put(moneyType, new DenominatorCombination(moneyType, ++freq));
		}else{
			DenominatorCombination value = this.denominatorFrequencyMap.get(moneyType);
			int frequency = 0;
			if(value != null){
				frequency = value.getFrequency();
			}
			
			this.denominatorFrequencyMap.put(moneyType, new DenominatorCombination(moneyType, frequency +1));
			freq++;
		}
		return freq;
	}
	/**
	 * Calculates the remainder of amount
	 * @param amount
	 * @param denomination
	 * @return BigDecimal
	 */
	private BigDecimal calculateRemainder(BigDecimal amount, Denominator denomination) {
		int count = 0;
		while (amount.compareTo(denomination.getValue()) >= 0) {
			amount = amount.subtract(denomination.getValue());
			count++;
		}
		denominatorMap.put(denomination, count);
		return amount;
	}

	public static void main(String args[]) {
		DispenserService ch = new DispenserService();
		ch.getResponse("2.50");
	}
	/**
	 * Gets response
	 * 
	 * @param amount
	 * @return List<DenominatorCombination>
	 */
	public List<DenominatorCombination> getResponse(String amount){
		// Base condition.
		if(amount == null || amount == ""){
			LOGGER.error("Amount is invalid");
		}
		
		DenominatorCombination denominatorCombination = null;
		List<DenominatorCombination> denominators = new ArrayList<>();
		
		this.dispense(new BigDecimal(amount));
		for(Denominator tmpDen : this.denominator){
			denominatorCombination = this.denominatorFrequencyMap.get(tmpDen);
			if(denominatorCombination != null && denominatorCombination.getFrequency() > 0){
				denominators.add(denominatorCombination);
			}
		}
		return denominators;
	}
}
