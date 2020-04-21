package ir.ac.kntu;

import java.util.ArrayList;

public class PlannedTour extends Tour {
    private Date start;
    private Date end;
    private TourLeader tourLeader;

    public static void addPlannedTour(ArrayList<PlannedTour> plannedTours, ArrayList<Tour> rawTours) {
        PlannedTour plannedTour = new PlannedTour();
        System.out.println(Tour.rawToursToString(rawTours));
        System.out.print("Choose an area: ");
        String name = scanner.nextLine();
        for (Tour tour : rawTours) {
            if (tour.getArea().getName().equalsIgnoreCase(name)) {
                copyRawTourInPlannedTour(plannedTour,tour);
                break;
            }
        }
        System.out.println("Tour starts from: ");
        plannedTour.setStart(Date.setDate());
        plannedTour.setEnd(plannedTour.getStart().nextDay(plannedTour.getDuration()));
        boolean flag = true;
        while (flag) {
            System.out.println(TourLeader.tourLeaderNamesToString());
            System.out.print("Enter tour leader's full name or enter \"cancel\" and add tour leader: ");
            name = scanner.nextLine();
            if (name.equalsIgnoreCase("cancel")) {
                TourLeader.addTourLeader(Main.tourLeaders);
                continue;
            } else {
                plannedTour.setTourLeader(new TourLeader());
                for (TourLeader tourLeader : Main.tourLeaders) {
                    if (tourLeader.getFullName().equalsIgnoreCase(name) && tourLeader.getAreas().contains(plannedTour.getArea())) {
                        if (tourLeader.isAvailable(plannedTour.start, plannedTour.end)) {
                            flag = false;
                            plannedTour.setTourLeader(tourLeader);
                        } else {
                            System.out.println("this leader is not available");
                        }
                        break;
                    }
                }
            }
        }
        plannedTour.getTourLeader().getDot().add(plannedTour.getEnd());
        plannedTour.getTourLeader().getDot().add(plannedTour.getStart());
        plannedTours.add(plannedTour);
    }

    public static void copyRawTourInPlannedTour(Tour planned, Tour raw) {
        planned.setPlacesToVisit(raw.getPlacesToVisit());
        planned.setDestination(raw.getDestination());
        planned.setOrigin(raw.getOrigin());
        planned.setByAirplane(raw.isByAirplane());
        planned.setPrice(raw.getPrice());
        planned.setMaxParticipant(raw.getMaxParticipant());
        planned.setMinParticipant(raw.getMinParticipant());
        planned.setForeign(raw.isForeign());
        planned.setDuration(raw.getDuration());
        planned.setArea(raw.getArea());
    }

    public static ArrayList<Tour> castPlannedTORaw() {
        ArrayList<Tour> tours = new ArrayList<>();
        for (PlannedTour plannedTour : Main.plannedTours) {
            tours.add(plannedTour);
        }
        return tours;
    }

    public static PlannedTour searchByAreaAndDate(ArrayList<PlannedTour> plannedTours, String name, Date date) {
        for (PlannedTour plannedTour : plannedTours) {
            if(plannedTour.getArea().getName().equalsIgnoreCase(name) && plannedTour.getStart().equals(date)) {
                return plannedTour;
            }
        }
        return null;
    }

    public String ToString() {
        return super.ToString() + "\n" +
                "start: " + start.toString() + "\n" +
                "end: " + end.toString() + "\n" +
                "tourLeader: " + tourLeader.getFirstName() + " " + tourLeader.getLastName();
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public TourLeader getTourLeader() {
        return tourLeader;
    }

    public void setTourLeader(TourLeader tourLeader) {
        this.tourLeader = tourLeader;
    }
}
