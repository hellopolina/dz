package dz6.delivery.model;

public class Parcel {
    private String recipientName;
    private String recipientAddress;
    protected double parcelWeight;
    String trackingNumber;

    public Parcel(String recipientName, String recipientAddress, double parcelWeight, String trackingNumber) {
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.parcelWeight = parcelWeight;
        this.trackingNumber = trackingNumber;
    }

    public Parcel() {}

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public double getParcelWeight() {
        return parcelWeight;
    }

    public void setParcelWeight(double parcelWeight) {
        this.parcelWeight = parcelWeight;
    }

    public double calculateDeliveryPrice() {
        return 100 + parcelWeight * 30;
    }

    public void printInfo() {
        System.out.println("Parcel information: " + "\n" +
                "- Recipient Name: " + recipientName + "\n" +
                "- Recipient Address: " + recipientAddress + "\n" +
                "- Parcel Weight: " + parcelWeight + "\n" +
                "- Tracking Number: " + trackingNumber + "\n");
    }
}
