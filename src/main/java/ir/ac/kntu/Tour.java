package ir.ac.kntu;

import java.util.ArrayList;

public class Tour {
    private int duration;
    private int price;
    private int maxParticipant;
    private int minParticipant;
    private Area origin;
    private Area destination;
    private boolean foreign;
    private boolean ByAirplane;
    private ArrayList<Area> visitingPlaces = new ArrayList<>(duration);
}
