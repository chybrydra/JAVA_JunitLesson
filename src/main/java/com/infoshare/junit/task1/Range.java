package com.infoshare.junit.task1;

class Range {

    private final long lowerBound;
    private final long upperBound;

    Range(long lowerBound, long upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    boolean isInRange(long number) {
        return number >= lowerBound && number <= upperBound;
    }
}
