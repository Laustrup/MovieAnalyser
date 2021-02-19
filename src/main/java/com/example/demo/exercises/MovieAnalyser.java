package com.example.demo.exercises;

import com.example.demo.exercises.exercise_5.Awards;
import com.example.demo.exercises.exercise_4.TopTen;
import com.example.demo.exercises.exercise_1.WelcomeMessage;
import com.example.demo.exercises.exercise_3.RandomMovie;
import com.example.demo.exercises.exercise_2.FirstMovie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;

@Controller
public class MovieAnalyser {

    Awards awards = new Awards();
    FirstMovie firstMovie = new FirstMovie();
    RandomMovie randomMovie = new RandomMovie();
    TopTen topTen = new TopTen();
    WelcomeMessage welcomeMessage = new WelcomeMessage();

        @ResponseBody
        @GetMapping("/howManyWonAnAward")
        public String printAmountsOfAwards() {
            try {
                return awards.getAmountsOfAwards();
            }
            catch (FileNotFoundException e) {
                return "Couldn't find file...";
            }
        }

    @ResponseBody
    @GetMapping("/getFirst")
    public String printFirstMovie() {
        try {
            return firstMovie.getFirstMovie();
        }
        catch (FileNotFoundException e) {
            return "Couldn't find file...";
        }
    }

    @ResponseBody
    @GetMapping("/getRandom")
    public String printRandomMovie() {
        try {
            return randomMovie.getRandomMovie();
        }
        catch (FileNotFoundException e) {
            return "Couldn't find file...";
        }
    }

    @ResponseBody
    @GetMapping("/getTenSortByPopularity")

    public String printTopTen() {

            return topTen.getTopTenPopularity();
    }

    @ResponseBody
    @GetMapping("/")
    public String printWelcomeMessage() {
        return welcomeMessage.getMessage();
    }

}


