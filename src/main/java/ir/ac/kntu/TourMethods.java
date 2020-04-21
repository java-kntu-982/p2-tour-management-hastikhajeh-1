package ir.ac.kntu;

import java.util.ArrayList;

public class TourMethods {
    public static Tour searchByArea(ArrayList<Tour> tours, String name) {
        for (Tour tour : tours) {
            if (tour.getArea().getName().equalsIgnoreCase(name)) {
                return tour;
            }
        }
        return null;
    }

    public static ArrayList<Tour> searchTourByDuration(ArrayList<Tour> tours, int duration) {
        ArrayList<Tour> tours1 = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getDuration() == duration) {
                tours1.add(tour);
            }
        }
        return tours1;
    }

    public static Tour searchByPlace(ArrayList<Tour> tours, String place) {
        for (Tour tour : tours) {
            for (String name : tour.getPlacesToVisit()) {
                if (name.equalsIgnoreCase(place)) {
                    return tour;
                }
            }
        }
        return null;
    }

    public static ArrayList<Tour> searchByMinAndMaxParticipants(ArrayList<Tour> tours, int min, int max) {
        ArrayList<Tour> tours1 = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getMinParticipant() == min && tour.getMaxParticipant() == max) {
                tours1.add(tour);
            }
        }
        return tours1;
    }

    public static ArrayList<Tour> searchByPrice(ArrayList<Tour> tours, int price) {
        ArrayList<Tour> tours1 = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getPrice() == price) {
                tours1.add(tour);
            }
        }
        return tours1;
    }

    public static ArrayList<Tour> searchMoreExpensivePrice(ArrayList<Tour> tours, int price) {
        ArrayList<Tour> tours1 = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getPrice() > price) {
                tours1.add(tour);
            }
        }
        return tours1;
    }

    public static ArrayList<Tour> searchCheaperPrice(ArrayList<Tour> tours, int price) {
        ArrayList<Tour> tours1 = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getPrice() < price) {
                tours1.add(tour);
            }
        }
        return tours1;
    }

    public static ArrayList<Tour> searchBetween2Price(ArrayList<Tour> tours, int min, int max) {
        ArrayList<Tour> tours1 = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getPrice() > min && tour.getPrice() < max) {
                tours1.add(tour);
            }
        }
        return tours1;
    }

}
