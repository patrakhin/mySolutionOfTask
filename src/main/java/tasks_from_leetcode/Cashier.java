package tasks_from_leetcode;

import java.util.*;

public class Cashier {
    private final int n;
    private final int discount;
    private final HashMap<Integer, Integer> listPrices = new HashMap<>();
    private int countCustomers;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        for (int i = 0; i < products.length; i++) {
            this.listPrices.put(products[i],prices[i]);
        }
        this.countCustomers = 0;
    }

    public double getBill(int[] product, int[] amount) {
        this.countCustomers ++;
        double subBilling = 0;
        double totalBilling = 0;
        boolean isCustomerMultiple = false;
        if (countCustomers % n == 0) {
            isCustomerMultiple = true;
        }
        for (int i = 0; i < product.length; i++) {
            subBilling = (listPrices.get(product[i])) * amount [i];
            totalBilling = totalBilling + subBilling;
        }
        if (discount == 0) {
            return totalBilling;
        }
        if (isCustomerMultiple && discount != 0) {
            totalBilling = totalBilling * ((100.00 - discount) / 100.00);
            return totalBilling;
        }
        return totalBilling;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */
