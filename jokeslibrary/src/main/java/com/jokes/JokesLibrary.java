package com.jokes;



import java.util.ArrayList;
import java.util.List;

public class JokesLibrary {

    public static List<String> getJoke() {
        List<String> stringList =  new ArrayList<>();
        stringList.add(" It is so cold outside I saw a politician with his hands in his own pockets.");
        stringList.add("My wife’s cooking is so bad we usually pray after our food.");
        stringList.add("My girlfriend told me I was one in a million. When I looked through her text messages, I had to admit she was right.");
        stringList.add("I can’t believe I forgot to go to the gym today. That’s 7 years in a row now.");
        return stringList;
    }
}
