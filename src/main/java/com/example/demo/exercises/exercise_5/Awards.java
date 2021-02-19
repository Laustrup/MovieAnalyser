package com.example.demo.exercises.exercise_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Awards {

    private File file = new File("src/main/resources/static/film-new.csv");
    private ArrayList<String> movies = new ArrayList<>();

    private int amounts = 0;

    Scanner scan;

    public String getAmountsOfAwards() throws FileNotFoundException {
        scan = new Scanner(file);

        scan.nextLine();
        scan.nextLine();

        while (scan.hasNextLine()) {
            String[] arr = scan.nextLine().split(";");

            movies.add(arr[5]);

        }

        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).equals("Yes")) {
                amounts++;
            }
        }

        return String.valueOf(amounts) + " is the amount of movies that won an award from the list.";
    }

}
