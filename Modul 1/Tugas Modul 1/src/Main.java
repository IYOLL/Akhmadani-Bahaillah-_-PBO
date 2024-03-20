import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Student currentStudent = null;
    private static Admin currentAdmin = null;

    public static void main(String[] args) {
        int choice;
        while (true) {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    if (currentStudent == null) {
                        currentStudent = loginAsStudent();
                    } else {
                        System.out.println("You are already logged in as a student.");
                    }
                    break;
                case 2:
                    if (currentAdmin == null) {
                        currentAdmin = loginAsAdmin();
                    } else {
                        System.out.println("You are already logged in as an admin.");
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static Student loginAsStudent() {
        if (currentStudent != null) {
            System.out.println("You are already logged in as a student.");
            System.out.print("Would you like to log in as a student again? (Y/N): ");
            String choice = scanner.nextLine().trim();
            if (!choice.equalsIgnoreCase("Y")) {
                return null;
            }
        }
        System.out.print("Enter your NIM: ");
        String nim = scanner.nextLine();
        if (nim.length() != 15) {
            System.out.println("Invalid NIM length. NIM must be exactly 15 digits.");
            return null;
        }
        Student student = Student.findStudentByNIM(nim);
        if (student == null) {
            System.out.println("User not found.");
            return null;
        } else {
            System.out.println("Successful login as Student.");
            return student;
        }
    }



    private static Admin loginAsAdmin() {
        System.out.print("Enter your username (admin): ");
        String username = scanner.nextLine();
        System.out.print("Enter your password (admin): ");
        String password = scanner.nextLine();
        Admin admin = Admin.findAdminByUsernameAndPassword(username, password);
        if (admin == null) {
            System.out.println("Admin user not found.");
            return null;
        } else {
            System.out.println("Successful login as Admin.");
            return admin;
        }
    }

    private static void displayMenu() {
        System.out.println("===== Library System ====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Choose option (1-3): ");
    }
}

class Student {
    private String nim;

    private Student(String nim) {
        this.nim = nim;
    }

    public static Student findStudentByNIM(String nim) {
        if (nim.length() != 15) {
            return null;
        } else {
            return new Student(nim);
        }
    }

    public String getNIM() {
        return nim;
    }
}

class Admin {
    private String username;
    private String password;

    private Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Admin findAdminByUsernameAndPassword(String username, String password) {
        if (username.equals("admin") &&  password.equals("admin")) {
            return new Admin(username, password);
        } else {
            return null;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
