package com.example.demo.exercises.exercise_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstMovie {

    private File file = new File("src/main/resources/static/film-new.csv");
    private ArrayList<String> movies = new ArrayList<>();

    Scanner scan;

    public String getFirstMovie() throws FileNotFoundException {
        scan = new Scanner(file);

        scan.nextLine();
        scan.nextLine();

        while (scan.hasNextLine()) {
            String[] arr = scan.nextLine().split(";");

            movies.add(arr[2]);
        }

        return "The first movie is " + movies.get(0);
    }
}
