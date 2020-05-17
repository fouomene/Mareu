package com.developpeuseoc.mareu.service;

import com.developpeuseoc.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeApiServiceGenerator {

    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting(0, "Réunion A", 14, 00, "Peach", "L'application MaRéu", "maxime@lamzone.com, alex@lamzone.com, laurine@lamzone.com"),
            new Meeting(1, "Réunion B", 16, 00, "Mario", "L'application Entrevoisins", "paul@lamzone.com, viviane@lamzone.com, leo@lamzone.com"),
            new Meeting(2, "Réunion C", 19, 00, "Luigi", "L'application MagicGitHub", "amandine@lamzone.com, luc@lamzone.com, jean@lamzone.com"),
            new Meeting(3, "Réunion D", 17, 00, "Bowser", "Optimisation Maréu", "sarah@lamzone.com, anais@lamzone.com, iliass@lamzone.com"),
            new Meeting(4, "Réunion E", 11, 30, "Cappy", "L'application Pizza", "pauline@lamzone.com, hector@lamzone.com, laurine@lamzone.com"),
            new Meeting(5, "Réunion F", 10, 30, "Tiara", "L'application ToDo", "alexandra@lamzone.com, marie@lamzone.com, theo@lamzone.com")
            );

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }

    public static List<String> DUMMY_PLACES = Arrays.asList(
            "Mario",
            "Luigi",
            "Peach",
            "Bowser",
            "Yoshi",
            "Toad",
            "Daisy",
            "Toadette",
            "Cappy",
            "Tiara");

    public static List<String> DUMMY_COLOR = Arrays.asList(
            "#FF3333",
            "#33FF33",
            "#FF66B2",
            "#FFFF66",
            "#99FF99",
            "#99CCFF",
            "#FFB266",
            "#FF99FF",
            "#E0E0E0",
            "#F0E68C");
}
