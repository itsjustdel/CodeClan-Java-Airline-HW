package Logistics;

public enum Plane {
    BIG(100,1000),
    MEGABIG(200,1500),
    SMALLER(50,500),
    PROPELLOR(25, 250);

    private int capacity;
    private int totalWeight;

    Plane(int capacity, int totalWeight) {
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}
