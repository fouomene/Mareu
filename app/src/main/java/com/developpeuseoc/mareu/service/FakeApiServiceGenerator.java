package com.developpeuseoc.mareu.service;

import com.developpeuseoc.mareu.model.CoWorker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeApiServiceGenerator {

    public static List<CoWorker> DUMMY_COWORKERS = Arrays.asList(
            new CoWorker("Maxime", "maxime@lamzone.com"),
            new CoWorker("Paul", "paul@lamzone.com"),
            new CoWorker("Amandine", "amandine@lamzone.com"),
            new CoWorker("Alexandre", "alexandre@lamzone.com"),
            new CoWorker("Brice", "brice@lamzone.com"),
            new CoWorker("Caroline", "caroline@lamzone.com"),
            new CoWorker("Francis", "francis@lamzone.com"),
            new CoWorker("Alexandra", "alexandra@lamzone.com"),
            new CoWorker("Marie", "marie@lamzone.com"),
            new CoWorker("Laurine", "laurine@lamzone.com"),
            new CoWorker("Axel", "axel@lamzone.com"),
            new CoWorker("Steve", "steve@lamzone.com")
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
