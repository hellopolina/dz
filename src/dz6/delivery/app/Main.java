package dz6.delivery.app;

import dz6.delivery.model.ExpressParcel;
import dz6.delivery.model.FragileParcel;
import dz6.delivery.model.Parcel;
import dz6.delivery.service.ParcelService;

public class Main {

    public static void main(String[] args) {
        Parcel parcel = new Parcel("Roberto Carlos", "123 Arbat st", 7.5, "TR-569891");
        FragileParcel fragileParcel = new FragileParcel("Carolina Ferrero", "456 Pushkin st", 3.1, "TR-157895", true);
        ExpressParcel expressParcel = new ExpressParcel("Cristiano Eaglesias", "789 Mozart st", 16.92, "TR-367846", 12);
        Parcel parcelNoName = new Parcel();

        Parcel[] parcels = {parcel, fragileParcel, expressParcel, parcelNoName};

        ParcelService parcelService = new ParcelService();
        parcelService.printParcelsReport(parcels);
    }
}