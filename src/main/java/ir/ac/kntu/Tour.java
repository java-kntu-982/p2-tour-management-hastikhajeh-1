package ir.ac.kntu;

import java.util.ArrayList;

public class Tour {
    private int duration;
    private int price;
    private int maxParticipant;
    private int minParticipant;
    private Area area;
    private String origin;
    private String destination;
    private boolean foreign;
    private boolean ByAirplane;
    private ArrayList<String> PlacesToVisit = new ArrayList<>(duration);
    private Date start;
    private Date end;
    private TourLeader tourLeader;
}
