package com.switchfully.selfeval.eurder.domain.item.itemResupply;

public enum Indicator {
    STOCK_LOW(0,4,2),
    STOCK_MEDIUM(5,9,1),
    STOCK_HIGH(10,Integer.MAX_VALUE,0);
    private final int min;
    private final int max;
    private final int urgency;

    Indicator(int min, int max,int urgency) {
        this.min = min;
        this.max = max;
        this.urgency = urgency;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getUrgency() {
        return urgency;
    }
}
