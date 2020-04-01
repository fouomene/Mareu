package com.developpeuseoc.mareu.service;

import com.developpeuseoc.mareu.model.CoWorker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeApiServiceGenerator {

    public static List<CoWorker> DUMMY_COWORKERS = Arrays.asList(
            new CoWorker("https://images.pexels.com/photos/937481/pexels-photo-937481.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","Maxime", "maxime@lamzone.com"),
            new CoWorker("https://images.pexels.com/photos/842567/pexels-photo-842567.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","Paul", "paul@lamzone.com"),
            new CoWorker("https://images.pexels.com/photos/1181690/pexels-photo-1181690.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Amandine", "amandine@lamzone.com"),
            new CoWorker("https://images.pexels.com/photos/716411/pexels-photo-716411.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","Alexandre", "alexandre@lamzone.com"),
            new CoWorker("https://images.pexels.com/photos/1586996/pexels-photo-1586996.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Brice", "brice@lamzone.com"),
            new CoWorker("https://images.pexels.com/photos/3785419/pexels-photo-3785419.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Caroline", "caroline@lamzone.com"),
            new CoWorker("https://images.pexels.com/photos/3752859/pexels-photo-3752859.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","Francis", "francis@lamzone.com"),
            new CoWorker("https://images.pexels.com/photos/733872/pexels-photo-733872.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Alexandra", "alexandra@lamzone.com"),
            new CoWorker("https://images.pexels.com/photos/1586973/pexels-photo-1586973.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Marie", "marie@lamzone.com"),
            new CoWorker("https://images.pexels.com/photos/2381069/pexels-photo-2381069.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Laurine", "laurine@lamzone.com"),
            new CoWorker("https://images.pexels.com/photos/840916/pexels-photo-840916.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Axel", "axel@lamzone.com"),
            new CoWorker("https://images.pexels.com/photos/2216607/pexels-photo-2216607.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Steve", "steve@lamzone.com")
    );

    static List<CoWorker> generateCoWorkers() {
        return new ArrayList<CoWorker>(DUMMY_COWORKERS);
    }

    public static List<String> DUMMY_PLACES = Arrays.asList(
            "Soleil",
            "Mercure",
            "Venus",
            "Terre",
            "Lune",
            "Mars",
            "Jupiter",
            "Saturne",
            "Uranus",
            "Neptune");
}
