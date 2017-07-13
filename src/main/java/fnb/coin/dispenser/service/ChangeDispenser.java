package fnb.coin.dispenser.service;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ChangeDispenser {
		private static final BigDecimal HunderedDOLLARS = new BigDecimal("100.00");
		private static final BigDecimal FIFTYDOLLARS = new BigDecimal("50.00");
        private static final BigDecimal TWENTYDOLLARS = new BigDecimal("20.00");
        private static final BigDecimal TENDOLLARS = new BigDecimal("10.00");
        private static final BigDecimal FIVEDOLLARS = new BigDecimal("5.00");
        private static final BigDecimal ONEDOLLAR = new BigDecimal("1.00");
        private static final BigDecimal TWENTYFIVECENTS = new BigDecimal("0.25");
        private static final BigDecimal TENCENTS = new BigDecimal("0.10");
        private static final BigDecimal FIVECENTS = new BigDecimal("0.05");
        private static final BigDecimal ONECENT = new BigDecimal("0.01");
        private static final Integer ZERO = new Integer(0);

        private Map<BigDecimal, Integer> denominationMap = new HashMap<BigDecimal, Integer>();

        public ChangeDispenser() {
        	denominationMap.put(HunderedDOLLARS, ZERO);
            denominationMap.put(FIFTYDOLLARS, ZERO);
            denominationMap.put(TWENTYDOLLARS, ZERO);
            denominationMap.put(TENDOLLARS, ZERO);
            denominationMap.put(FIVEDOLLARS, ZERO);
            denominationMap.put(ONEDOLLAR, ZERO);
            denominationMap.put(TWENTYFIVECENTS, ZERO);
            denominationMap.put(TENCENTS, ZERO);
            denominationMap.put(FIVECENTS, ZERO);
            //denominationMap.put(ONECENT, ZERO);
        }

        // Method that does the logical work
        public void dispense(BigDecimal amount) {
            System.out.println("Entering dispense method");
            System.out.println("Amount submitted: " + amount.toString());
            int freq = 0;
            
            if (amount.compareTo(TWENTYDOLLARS) == 0 || amount.compareTo(TWENTYDOLLARS) == 1) {
                System.out.println("$20 block");
                amount = calculateRemainder(amount, TWENTYDOLLARS);
            }

            if (amount.compareTo(TENDOLLARS) == 0 || amount.compareTo(TENDOLLARS) == 1) {
                System.out.println("$10 block");
                amount = calculateRemainder(amount, TENDOLLARS);
            }

            if (amount.compareTo(FIVEDOLLARS) == 0 || amount.compareTo(FIVEDOLLARS) == 1) {
                System.out.println("$5 block");
                amount = calculateRemainder(amount, FIVEDOLLARS);
            }

            if (amount.compareTo(ONEDOLLAR) == 0 || amount.compareTo(ONEDOLLAR) == 1) {
                System.out.println("$1 block");
                amount = calculateRemainder(amount, ONEDOLLAR);
            }

            if (amount.compareTo(TWENTYFIVECENTS) == 0 || amount.compareTo(TWENTYFIVECENTS) == 1) {
                System.out.println("25c block");
                amount = calculateRemainder(amount, TWENTYFIVECENTS);
            }

            if (amount.compareTo(TENCENTS) == 0 || amount.compareTo(TENCENTS) == 1) {
                System.out.println("10c block");
                amount = calculateRemainder(amount, TENCENTS);
            }

            if (amount.compareTo(FIVECENTS) == 0 || amount.compareTo(FIVECENTS) == 1) {
                System.out.println("5c block");
                amount = calculateRemainder(amount, FIVECENTS);
            }

          /*  if (amount.compareTo(ONECENT) == 0 || amount.compareTo(ONECENT) == 1) {
                System.out.println("1c block");
                amount = calculateRemainder(amount, ONECENT);
            }*/
        }

        private BigDecimal calculateRemainder(BigDecimal dollarAmount, BigDecimal denomination) {
            System.out.println("Entering calculateRemainder method");
            int count = 0;
            while (dollarAmount.compareTo(denomination) == 0 || dollarAmount.compareTo(denomination) == 1) {
                dollarAmount = dollarAmount.subtract(denomination);
                count++;
            }
            denominationMap.put(denomination, count);
            return dollarAmount;
        }

        public Map<BigDecimal, Integer> getDenominationMap() {
            return denominationMap;
        }

        public void setDenominationMap(Map<BigDecimal, Integer> denominationMap) {
            this.denominationMap = denominationMap;
        }
        
        public static void main(String args []){
        	ChangeDispenser ch = new ChangeDispenser();
        	ch.dispense(new BigDecimal("25.50"));
        }
        
}

