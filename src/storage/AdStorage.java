package storage;

import exception.ModelNotFoundException;
import model.Ad;
import model.Category;
import model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AdStorage {
    private List<Ad> adds;



    public AdStorage() {
        adds = new ArrayList<>();
    }

    public void addAd(Ad value) {
        adds.add(value);


    }



    public int getAdSize() {
        return adds.size();
    }

    public boolean isAdEmpty() {
        return adds.isEmpty();
    }

    public void printAd() {

        for (Ad ad : adds) {
            System.out.println(ad);

        }
    }

    public Ad getAdByTitle(String title) throws ModelNotFoundException {
        for (Ad add : adds) {
            if (add.getTitle().equalsIgnoreCase(title)) {
                adds.remove(add);}
        }
        throw new ModelNotFoundException(String.format("Ad with %s title does not exist",title));
        }



    public void printAdsByUser(User currentUser) {
        for (int i = 0; i < getAdSize(); i++) {
            Ad ad = adds.get(i);
            if (ad.getAuthor().equals(currentUser)) {
                printAd(ad);

            }
        }
    }
    public void deleteMyAllAds(User currentUser) {
        adds.removeIf(add -> add.getAuthor().equals(currentUser));

        System.out.println("All Ads removed");
        }





    private void printAd(Ad ad) {
        System.out.println("title:" + ad.getTitle());
        System.out.println("text: " + ad.getText());
        System.out.println("price: " + ad.getPrice());
        System.out.println("Date: " + ad.getCreatedDate());
        System.out.println("Category: " + ad.getCategory());
        System.out.println("User: " + ad.getAuthor());
        System.out.println("--------------------------------------------");
    }

    public void printAdByCategory(Category category) {


        for (int i = 0; i < getAdSize(); i++) {
            Ad ad = adds.get(i);
            if (ad.getCategory() == category) {
                System.out.println(ad);
            }

        }
    }

    public void printAllAdsByTitleSort() {

        class TitleCompare implements Comparator<Ad> {

            @Override
            public int compare(Ad o1, Ad o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }

        }
        TitleCompare Title=new TitleCompare();
        adds.sort(Title);
        for (Ad add : adds) {
            System.out.println(add);
        }


    }

    public void printAllAdsByDateSort() {
        class DateCompare implements Comparator<Ad>{


            @Override
            public int compare(Ad o1, Ad o2) {
                return o1.getCreatedDate().compareTo(o2.getCreatedDate());
            }
        }
        DateCompare dateCompare=new DateCompare();
        adds.sort(dateCompare);
        for (Ad add : adds) {
            System.out.println(add);

        }



    }
    //   երկրորդ տարբերակն title ով ջնջելու
//    public void deleteAdByTitle(String title) {
//        adds.removeIf(add -> add.getTitle().equals(title));
//        System.out.println("Ad successful removed");
//
//        }
    }






