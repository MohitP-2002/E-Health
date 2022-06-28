import java.util.*;
import java.lang.String;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class Main {
    // constructor
    Main() {
        System.out.println();
        System.out.println("-----------------------E-Healthify-----------------------");
        // System.out.println();
    }

    // global declarations
    Scanner sc = new Scanner(System.in);
    String name;
    String address;
    long contact;
    int age;
    String bg;
    String sex;
    String disease;
    String dayMonth;

    // login validation
    String readString() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private void pressEnterKeyToContinue() {
        System.out.println("Press Enter Key to continue further..");
        try {
            System.in.read();
            list();
        } catch (Exception e) {
            System.out.println("Press <Enter> Key to Continue..");
            pressEnterKeyToContinue();
        }
    }

    void login() {
        System.out.println();
        System.out.print("Login PassWord: ");
        String passWordEntered = sc.next();
        if (passWordEntered.equals("mohit@30")) {
            System.out.println();
            System.out.println("Access Granted");
            pressEnterKeyToContinue();
        } else {
            System.out.println();
            System.out.println("Access Denied");

        }
    }

    void list() {
        System.out.println();
        System.out.println("Welcome to the Dashboard");
        System.out.println();
        System.out.println("Please select any one of the following:");
        System.out.println("1. Add file of new patient");
        System.out.println("2. History of a Patient");
        System.out.println("3. Bill of a Patient");
        System.out.println("4. Add Diagnosis information of a patient");
        System.out.println("5. Need Help!");
        System.out.println("6. Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
        int c = sc.nextInt();
        switch (c) {
            case 1:
                addFile();
                break;
            case 2:
                historyPatient();
                break;
            case 3:
                billPatient();
                break;
            case 4:
                addDiagnosisInfo();
                break;
            case 5:
                help();
                break;
            case 6:
                exit();
                break;
            default:
                list();
                break;
        }
    }

    void exit() {
        System.out.println("\nThank you for using the application\n\n Stay Healthy and Safe\n");
        System.exit(0);
    }

    void historyPatient() {
        System.out.print("Enter file name of the patient: ");
        String fileName = sc.next();
        String line = null;
        try {
            FileReader fwrite = new FileReader(fileName + ".txt");
            BufferedReader bufferedReader = new BufferedReader(fwrite);
            System.out.println();
            System.out.println(".......................INFORMATION OF THE PATIENT.......................  ");

            System.out.println();
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            pressEnterKeyToContinue();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file '" + fileName + "'");
            pressEnterKeyToContinue();
        } catch (IOException e) {
            System.out.println("Error reading file '" + fileName + "'");
            pressEnterKeyToContinue();
        }
    }

    void billPatient() {
        long bedCharges;
        long noOfDays;
        long doctorCharge;
        long serviceCharge;
        System.out.print("Enter file name of the patient: ");
        String fileName = sc.next();
        String line = null;
        getCurrentTimeUsingDate();
        try {
            FileReader fwrite = new FileReader(fileName + ".txt");
            BufferedReader bufferedReader = new BufferedReader(fwrite);
            System.out.println();
            System.out.println(".......................INFORMATION OF THE PATIENT.......................  ");

            System.out.println();
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            PrintWriter type = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".txt", true)));
            getCurrentTimeUsingDate();
            // Always close files.
            bufferedReader.close();
            System.out.println();
            type.print("...........................................................................");

            System.out.println("The Date and Time of adding the information are: " + dayMonth);
            type.println("Date of issuance is = " + dayMonth);
            System.out.print("Number of days Patient stayed in bed: ");
            noOfDays = sc.nextLong();
            System.out.print("Bed Charges/day = ");
            bedCharges = sc.nextLong();
            System.out.print("Total Bed Charges: " + (noOfDays * bedCharges));
            type.println("Total Bed Charges = " + (noOfDays * bedCharges));
            System.out.print("Doctor's Charge = ");
            doctorCharge = sc.nextLong();
            type.println("Doctor's fee = " + doctorCharge);
            System.out.print("Extra Charges involving caretaker charge, food etc = ");
            serviceCharge = sc.nextLong();
            type.println("Service Charge = " + serviceCharge);
            type.println("Total Charge = " + (noOfDays * bedCharges) + doctorCharge + serviceCharge);
            type.print("...........................................................................");
            System.out.print("Total Charge = " + (noOfDays * bedCharges) + doctorCharge + serviceCharge);
            System.out.println(
                    ".............................................................................................");
            System.out.println("The patient's Bill information is recorded successfully");
            type.close();
        } catch (Exception e) {
            System.out.println("Unable to open " + fileName);
        }
        pressEnterKeyToContinue();
    }

    void help() {
        System.out.println("E-Healthify introduces the following features:\n");
        System.out.println("Add File of Patient: Add the patient to the database of our service.\n");
        System.out.println("History: Retrieve the information of past records of the patient.\n");
        System.out.println("Bill: Enter the bill issued to the Patient for treatment, medicines etc.\n");
        System.out.println("Add Diagnostic Information: Enter the information of the diagnosis done to the patient.\n");
        System.out.println("Help: Help manual for the application\n");
        System.out.println("Exit: Exits the application\n");
    }

    void addDiagnosisInfo() {
        String doctorName;
        String specialty;
        String symptoms;
        String medicines;
        System.out.print("Enter file name of the patient: ");
        String fileName = sc.next();
        String line = null;
        getCurrentTimeUsingDate();
        try {
            FileReader fwrite = new FileReader(fileName + ".txt");
            BufferedReader bufferedReader = new BufferedReader(fwrite);
            System.out.println();
            System.out.println(".......................INFORMATION OF THE PATIENT.......................  ");

            System.out.println();
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            PrintWriter type = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".txt", true)));
            getCurrentTimeUsingDate();
            // Always close files.
            bufferedReader.close();
            System.out.println();
            System.out.println("The Date and Time of adding the information are: " + dayMonth);
            type.println("Date of issuance is: " + dayMonth);
            System.out.print("Doctor's Name: ");
            doctorName = readString();
            type.println("Name of the Doctor: " + doctorName);
            System.out.print("Specialty of Doctor: ");
            specialty = readString();
            type.println("Specialty of Doctor: " + specialty);
            System.out.print("Symptoms: ");
            symptoms = readString();
            type.println("Symptoms: " + symptoms);
            System.out.print("Medicines issued: ");
            medicines = readString();
            type.println("Medicines issued: " + medicines);
            System.out.println();
            System.out.println(
                    ".............................................................................................");
            System.out.println("The patient's diagnosis information is recorded successfully");
            type.close();
        } catch (Exception e) {
            System.out.println("Unable to open " + fileName);
        }
        pressEnterKeyToContinue();
    }

    void addFile() {
        System.out.print("Enter file name of the patient: ");
        String fileName = sc.next();
        getCurrentTimeUsingDate();
        try {
            FileWriter fwrite = new FileWriter(fileName + ".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fwrite);
            System.out.println();
            System.out.println(
                    "File " + fileName + " created successfully.\nGo ahead and enter the details of the patient");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println();
            bufferedWriter.write("Date and Time of Registration: " + dayMonth);
            String uniqueID = UUID.randomUUID().toString();
            bufferedWriter.newLine();
            System.out.println();
            System.out.println("The unique ID generated is: " + uniqueID);
            bufferedWriter.write("ID: " + uniqueID);
            bufferedWriter.newLine();
            System.out.println();
            System.out.print("Full Name: ");
            name = readString();
            bufferedWriter.write("Name: " + name);
            bufferedWriter.newLine();
            System.out.print("Address: ");
            address = readString();
            bufferedWriter.write("Address: " + address);
            bufferedWriter.newLine();
            System.out.print("Contact: ");
            contact = sc.nextLong();
            bufferedWriter.write("Contact Number: " + contact);
            bufferedWriter.newLine();
            System.out.print("Age: ");
            age = sc.nextInt();
            bufferedWriter.write("Age: " + age);
            bufferedWriter.newLine();
            System.out.print("Sex: ");
            sex = sc.next();
            bufferedWriter.write("Sex: " + sex);
            bufferedWriter.newLine();
            System.out.print("Major diseases suffered with: ");
            disease = sc.next();
            bufferedWriter.write("Major diseases suffered: " + disease);
            bufferedWriter.newLine();
            System.out.println();
            bufferedWriter.write(
                    "------------------------------------------------------------------------------------------");
            bufferedWriter.newLine();
            bufferedWriter.close();
            System.out.println("The patient's information is recorded successfully");
            System.err.println(
                    "----------------------------------------------------------------------------------------------");
            System.out.println();

        } catch (Exception e) {
            System.out.println("Unexpected error occurred -> " + e);
        }
        pressEnterKeyToContinue();
    }

    public void getCurrentTimeUsingDate() {
        DateTimeFormatter d = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        dayMonth = d.format(now);
    }

    // main method
    public static void main(String[] args) {
        Main obj = new Main();
        obj.login();
    }
}