class Truck extends Vehicle implements Rentable {
    private double loadCapacity; // Load capacity in tons

    public Truck(String vehicleId, String model, double baseRentalRate, double loadCapacity) {
        super(vehicleId, model, baseRentalRate);
        setLoadCapacity(loadCapacity);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days + (loadCapacity * 10); // Additional cost based on load capacity
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public String getSpecialFeatures() {
        return "Load capacity: " + loadCapacity + " tons";
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            customer.addRental(this, days);
            System.out.println("Truck rented to " + customer.getName() + " for " + days + " days.");
        } else {
            System.out.println("Truck is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Truck returned.");
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        if (loadCapacity > 0) {
            this.loadCapacity = loadCapacity;
        } else {
            throw new IllegalArgumentException("Load capacity must be positive.");
        }
    }
}