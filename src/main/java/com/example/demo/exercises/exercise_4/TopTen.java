package com.example.demo.exercises.exercise_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class TopTen {

    private File file = new File("src/main/resources/static/film-new.csv");

    private ArrayList<Integer> popularityFromFile = new ArrayList<>();
    private ArrayList<String> titleFromFile = new ArrayList<>();

    private ArrayList<Integer> popularityFromRandom = new ArrayList<>();
    private ArrayList<String> titleFromRandom = new ArrayList<>();

    private ArrayList<Integer> randomList = new ArrayList<>();

    private int[] popularityToList = new int[10];
    private String[] titlesToList = new String[10];

    private String res = "Top 10 is ";
    private int amountsOnTheList = 0;

    private Scanner scan;
    private Random rand = new Random();

    public String getTopTenPopularity() {

        try {
            scanFile();

            createFromRandom();

            editTenBest();

            for (int i = 0; i < popularityToList.length; i++) {
                res += i+1 + ": " + titlesToList[i];
            }
        }
        catch (FileNotFoundException e) {
            res = "Couldn't find file";
        }

        return res;
    }

    private void scanFile() throws FileNotFoundException {
        scan = new Scanner(file);

        scan.nextLine();
        scan.nextLine();

        while (scan.hasNextLine()) {
            String[] arr = scan.nextLine().split(";");

            popularityFromFile.add(Integer.parseInt(arr[4]));
            titleFromFile.add(arr[2]);
        }
    }

    private void createFromRandom() {

        for (int i = 0; i < 10; i++) {
            int random = rand.nextInt(popularityFromFile.size());

            for (int j = 0; j < randomList.size(); j++) {
                if (randomList.get(j) == random) {
                    random = rand.nextInt(popularityFromFile.size());
                    j = 0;
                }
            }
            //Checks if movie is already choosen

            randomList.add(random);

            popularityFromRandom.add(popularityFromFile.get(random));
            titleFromRandom.add(titleFromFile.get(random));
        }
    }

    private void editTenBest() {
        for (int i = 0; i < popularityFromRandom.size(); i++) {
            for (int j = 0; j < popularityToList.length; j++) {
                if (popularityFromRandom.get(i) > popularityToList[j]) {
                    if (j != 0) {
                        moveUpList(j - 1);
                    }
                    else {
                        moveUpList(j);
                    }
                    addToTopTen(i,j);
                    break;
                }
                else if (popularityFromRandom.get(i) == popularityToList[j]) {
                    moveUpList(j);
                    addToTopTen(i+1,j+1);
                    break;
                }
            }
        }
        // i goes through the randomly created list and j goes through the final resulting list
    }

    private void moveUpList(int j) {
        for (int k = amountsOnTheList; k > j; k--) {
            popularityToList[k] = popularityToList[k - 1];
            titlesToList[k] = titlesToList[k - 1];
        }
    }

    private void addToTopTen(int i, int j) {
        popularityToList[j] = popularityFromRandom.get(i);
        titlesToList[j] = titleFromRandom.get(i) + " - ";
        if (amountsOnTheList <= 10) {
            amountsOnTheList++;
        }
    }

    // Properly should had made it object-orientated...
}
