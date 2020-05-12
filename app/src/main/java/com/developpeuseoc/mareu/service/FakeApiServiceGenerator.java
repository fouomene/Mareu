package com.developpeuseoc.mareu.service;

import com.developpeuseoc.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeApiServiceGenerator {

    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting(0, "Réunion A", 10, 00, "Saturne", "L'application MaRéu", "alexandre@lamzone.com, marie@lamzone.com, laurie@lamzone.com"),
            new Meeting(1, "Réunion B", 12, 30, "Terre", "L'application Entrevoisins", "steve@lamzone.com, luc@lamzone.com, leo@lamzone.com"),
            new Meeting(2, "Réunion C", 11, 30, "Lune", "L'application MagicGitHub", "paul@lamzone.com, medi@lamzone.com, jean@lamzone.com"),
            new Meeting(3, "Réunion D", 17, 00, "Uranus", "Optimisation Maréu", "sarah@lamzone.com, anais@lamzone.com, iliass@lamzone.com"),
            new Meeting(4, "Réunion E", 18, 30, "Mars", "L'application Pizza", "pauline@lamzone.com, hector@lamzone.com, laurine@lamzone.com"),
            new Meeting(5, "Réunion F", 10, 30, "Venus", "L'application ToDo", "alexandra@lamzone.com, marie@lamzone.com, theo@lamzone.com")
            );

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
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

    public static List<String> DUMMY_COLOR = Arrays.asList(
            "#FF9999",
            "#E0E0E0",
            "#FFFF99",
            "#99FFFF",
            "#E2E2DC",
            "#FF0000",
            "#FFB266",
            "#F5FD7C",
            "#99FF99",
            "#99CCFF");
}
