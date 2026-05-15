package dz6.delivery.model;

public class ExpressParcel extends Parcel {
    private int deliveryHours;

    public ExpressParcel(String recipientName, String recipientAddress, double parcelWeight, String trackingNumber, int deliveryHours) {
        super(recipientName, recipientAddress, parcelWeight, trackingNumber);
        this.deliveryHours = deliveryHours;
    }

    public double calculateDeliveryPrice() {
        if (deliveryHours < 24) {
            return super.calculateDeliveryPrice() + 500;
        }
        return super.calculateDeliveryPrice();
    }

    public void printInfo() {
        super.printInfo();
        System.out.printf("Delivery deadline: %d \n", deliveryHours);
    }

}
