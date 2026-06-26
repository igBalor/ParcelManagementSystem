import java.sql.*;

public class ParcelDAO {

    Connection con;

    public ParcelDAO() {
        try {
            con = DBConnection.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Add Parcel
    public void addParcel(Parcel p) {

        try {

            String query = "INSERT INTO parcel VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, p.getParcelId());
            ps.setString(2, p.getTrackingCode());
            ps.setString(3, p.getSenderName());
            ps.setString(4, p.getReceiverName());
            ps.setString(5, p.getSource());
            ps.setString(6, p.getDestination());
            ps.setDouble(7, p.getWeight());
            ps.setString(8, p.getStatus());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Parcel Added Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Search Parcel by ID
    public void searchParcel(int parcelId) {

        try {

            String query = "SELECT * FROM parcel WHERE parcel_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, parcelId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Parcel ID : " + rs.getInt(1));
                System.out.println("Tracking Code : " + rs.getString(2));
                System.out.println("Sender : " + rs.getString(3));
                System.out.println("Receiver : " + rs.getString(4));
                System.out.println("Source : " + rs.getString(5));
                System.out.println("Destination : " + rs.getString(6));
                System.out.println("Weight : " + rs.getDouble(7));
                System.out.println("Status : " + rs.getString(8));

            } else {
                System.out.println("Parcel Not Found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Track Parcel using Tracking Code
    public void trackParcel(String trackingCode) {

        try {

            String query = "SELECT * FROM parcel WHERE tracking_code=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, trackingCode);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

               System.out.println("\n===== Parcel Tracking =====");
            System.out.println("Parcel ID      : " + rs.getInt("parcel_id"));
            System.out.println("Tracking Code  : " + rs.getString("tracking_code"));
            System.out.println("Sender         : " + rs.getString("sender_name"));
            System.out.println("Receiver       : " + rs.getString("receiver_name"));
            System.out.println("Source         : " + rs.getString("source_location"));
            System.out.println("Destination    : " + rs.getString("destination_location"));
            System.out.println("Weight         : " + rs.getDouble("weight"));
            System.out.println("Current Status : " + rs.getString("status"));

            } else {

                System.out.println("Invalid Tracking Code");

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update Status
    public void updateStatus(String trackingCode, String status) {

        try {

            String query =
                    "UPDATE parcel SET status=? WHERE tracking_code=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, status);
            ps.setString(2, trackingCode);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Status Updated Successfully");
            else
                System.out.println("Tracking Code Not Found");

        } catch (Exception e) {

            System.out.println(e);

        }
    }

    // Delete Parcel
    public void deleteParcel(int parcelId) {

        try {

            String query = "DELETE FROM parcel WHERE parcel_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, parcelId);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Parcel Deleted Successfully");
            else
                System.out.println("Parcel Not Found");

        } catch (Exception e) {

            System.out.println(e);

        }
    }

    // Display All Parcels
    public void displayAllParcels() {

        try {

            String query = "SELECT * FROM parcel";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                System.out.println("--------------------------------");
                System.out.println("Parcel ID : " + rs.getInt(1));
                System.out.println("Tracking Code : " + rs.getString(2));
                System.out.println("Sender : " + rs.getString(3));
                System.out.println("Receiver : " + rs.getString(4));
                System.out.println("Source : " + rs.getString(5));
                System.out.println("Destination : " + rs.getString(6));
                System.out.println("Weight : " + rs.getDouble(7));
                System.out.println("Status : " + rs.getString(8));

            }

        } catch (Exception e) {

            System.out.println(e);

        }
    }
}