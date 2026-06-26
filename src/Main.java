import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserDAO userDAO = new UserDAO();

        System.out.println("===== Parcel Management System =====");
        System.out.println("1. Register");
        System.out.println("2. Login");

        int choice = sc.nextInt();
        sc.nextLine();

        if(choice == 1) {

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            User user = new User(username, password);

            userDAO.register(user);
        }

        else if(choice == 2) {

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            boolean success =
                    userDAO.login(username, password);

            if(success) {

                System.out.println("Login Successful");

                ParcelDAO parcelDAO = new ParcelDAO();

                System.out.println("\n===== Parcel Dashboard =====");
                System.out.println("1. Book Parcel");
                System.out.println("2. Track Parcel");
                System.out.println("3. Logout");

                int option = sc.nextInt();
                sc.nextLine();

                if(option == 1) {

                    System.out.print("Parcel ID: ");
                    int parcel_id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Sender Name: ");
                    String sender = sc.nextLine();

                    System.out.print("Receiver Name: ");
                    String receiver = sc.nextLine();

                    System.out.print("Source: ");
                    String source = sc.nextLine();

                    System.out.print("Destination: ");
                    String destination = sc.nextLine();

                    System.out.print("Weight: ");
                    Double weight =  sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Status: ");
                    String status = sc.nextLine();

                    System.out.print("Tracking code: ");
                    String tracking_code = sc.nextLine();

                    


                    Parcel parcel = new Parcel(
                            parcel_id,
                            tracking_code,
                            sender,
                            receiver,
                            source,
                            destination,
                            weight,
                            status
                            
                    );

                    parcelDAO.addParcel(parcel);
                }

            
              else if(option == 2) {

                        System.out.print("Enter Tracking Code: ");
                        String trackingCode = sc.nextLine();

                        parcelDAO.trackParcel(trackingCode);

             }
              else if(option == 3) {

                        System.out.println("Logged Out Successfully.");

            }

            else {

                System.out.println(
                        "Invalid Username or Password");
            }
        }
    }   

        sc.close();
    }
}