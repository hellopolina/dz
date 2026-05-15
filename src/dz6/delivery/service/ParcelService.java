package dz6.delivery.service;

import dz6.delivery.model.Parcel;

public class ParcelService {

    public void printParcelsReport(Parcel[] parcels) {
        for(Parcel parcel: parcels) {
            parcel.printInfo();
            System.out.printf("Delivery price: %.2f\n", parcel.calculateDeliveryPrice());
            System.out.print("\n");
        }
    }
}
