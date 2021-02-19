package com.example.demo.exercises.exercise_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class RandomMovie {

    private File file = new File("src/main/resources/static/film-new.csv");
    private ArrayList<String> movies = new ArrayList<>();
    private Random rand = new Random();

    private int limit = 0;

    Scanner scan;

    public String getRandomMovie() throws FileNotFoundException {
        scan = new Scanner(file);

        scan.nextLine();
        scan.nextLine();

        while (scan.hasNextLine()) {
            String[] arr = scan.nextLine().split(";");

            movies.add(arr[2]);

            limit++;
        }

        int iRand = rand.nextInt(limit);

        return "watch " + movies.get(iRand);
    }
}
