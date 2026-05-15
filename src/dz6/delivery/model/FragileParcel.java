package dz6.delivery.model;

public class FragileParcel extends Parcel {
    private boolean requiresCarefulHandling;

    public FragileParcel(String recipientName, String recipientAddress, double parcelWeight, String trackingNumber, boolean requiresCarefulHandling) {
        super(recipientName, recipientAddress, parcelWeight, trackingNumber);
        this.requiresCarefulHandling = requiresCarefulHandling;
    }

    public double calculateDeliveryPrice() {
        return super.calculateDeliveryPrice() + 200;
    }

    public void printInfo() {
        super.printInfo();
        System.out.printf("Handle with care: %b \n", requiresCarefulHandling);
    }
}
