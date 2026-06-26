public class Parcel {

    private int parcelId;
    private String trackingCode;
    private String senderName;
    private String receiverName;
    private String source;
    private String destination;
    private double weight;
    private String status;

    public Parcel(int parcelId,
                  String trackingCode,
                  String senderName,
                  String receiverName,
                  String source,
                  String destination,
                  double weight,
                  String status) {

        this.parcelId = parcelId;
        this.trackingCode = trackingCode;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.status = status;
    }

    public int getParcelId() {
        return parcelId;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public String getStatus() {
        return status;
    }
}