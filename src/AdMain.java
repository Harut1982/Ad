import command.Commands;
import exception.ModelNotFoundException;
import model.Ad;
import model.Category;
import model.Gender;
import model.User;
import storage.AdStorage;
import storage.UserStorage;

import java.util.Date;
import java.util.Scanner;

public class AdMain implements Commands {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final AdStorage AD_STORAGE = new AdStorage();
    private static final UserStorage USER_STORAGE = new UserStorage();
    private static User currentUser = null;




    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Commands.printMainCommands();
            int command;
            try {
                command = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.out.println("invalid command");


            }

        }
    }

    private static void register() {
        try {
            System.out.println("Please input name,surname,GENDER(MALE,FEMALE),age,phoneNumber,password");
            String userStr = SCANNER.nextLine();
            String[] userData = userStr.split(",");
            User user = new User();
            user.setName(userData[0]);
            user.setSurname(userData[1]);
            user.setGender(Gender.valueOf(userData[2].toUpperCase()));
            user.setAge(Integer.parseInt(userData[3]));
            user.setPhoneNumber(userData[4]);
            user.setPassword(userData[5]);
            USER_STORAGE.addUser(userData[4], user);
            System.out.println("Thank You");

        } catch (Exception e) {
            System.out.println("Please input valid data ");
            register();
        }


    }

    private static void login() {
        System.out.println("Please input phone number,password ");
        String userStr = SCANNER.nextLine();
        String[] userData = userStr.split(",");
        try {
            currentUser = USER_STORAGE.getUserByPhoneNumberAndPassword(userData[0], userData[1]);
            Commands.printUserCommands();
            boolean isRun = true;
            while (isRun) {
                int command;
                try {
                    command = Integer.parseInt(SCANNER.nextLine());
                } catch (NumberFormatException e) {
                    command = -1;
                }
                switch (command) {
                    case LOGOUT:
                        isRun = false;
                        break;
                    case ADD_NEW_AD:
                        addNewAd();
                        break;
                    case PRINT_MY_ALL_ADS:
                        printMyAllAds();
                        break;
                    case PRINT_ALL_ADS:
                        printAllAds();
                        break;
                    case PRINT_ADD_BY_CATEGORY:
                        printAddByCategory();
                        break;
                    case PRINT_ALL_ADS_BY_TITLE_SORT:
                        AD_STORAGE.printAllAdsByTitleSort();
                        break;
                    case PRINT_ALL_ADS_BY_DATE_SORT:
                        AD_STORAGE.printAllAdsByDateSort();
                        break;
                    case DELETE_MY_ALL_ADS:
                        AD_STORAGE.deleteMyAllAds(currentUser);
                        break;
                    case DELETE_AD_BY_TITLE:
                        deleteAdByTitle();
                        break;
                    default:
                        System.out.println("invalid command");


                }

            }


        } catch (ModelNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Incorrect value! Please try again");
        }
    }




    private static void printAddByCategory() {
        System.out.println("Please input category name for search");
        String searchedName = SCANNER.nextLine();
        AD_STORAGE.printAdByCategory(Category.valueOf(searchedName.toUpperCase()));


    }

    private static void printAllAds() {
        if (AD_STORAGE.isAdEmpty()){
            System.out.println("Please add Ad first:");}
        AD_STORAGE.printAd();

    }

    private static void addNewAd() {
        System.out.println("Please input Ad data: title,text,price,CATEGORY(IT,ART,SOCIAL)");
        try {
            String adDataStr = SCANNER.nextLine();
            String[] adData = adDataStr.split(",");
             Ad ad = new Ad();
            ad.setTitle(adData[0]);
            ad.setText(adData[1]);
            ad.setPrice(adData[2]);
            ad.setCategory(Category.valueOf(adData[3].toUpperCase()));
            ad.setCreatedDate(new Date());
            ad.setAuthor(currentUser);
            AD_STORAGE.addAd(ad);
            System.out.println("Add was added!");
            Commands.printUserCommands();

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Incorrect value! Please try again");
            addNewAd();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private static void printMyAllAds() {
        if (AD_STORAGE.isAdEmpty()){
            System.out.println("Please add Ad first:");}
        AD_STORAGE.printAdsByUser(currentUser);

    }
    private static void deleteAdByTitle() {
        AD_STORAGE.printAdsByUser(currentUser);
        System.out.println("please select by title");
        String title = SCANNER.nextLine();
        try {
            AD_STORAGE.getAdByTitle(title);
        } catch (Exception e) {
            System.out.println("Ad successful removed");
        }

    }





    }


