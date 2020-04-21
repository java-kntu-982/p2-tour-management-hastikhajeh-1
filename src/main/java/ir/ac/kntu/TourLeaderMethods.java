package ir.ac.kntu;

import java.util.ArrayList;

public class TourLeaderMethods {
    public static TourLeader searchByName(ArrayList<TourLeader> tourLeaders, String firstName, String lastName) {
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).firstName.equals(firstName) && tourLeaders.get(i).lastName.equals(lastName)) {
                return tourLeaders.get(i);
            }
        }
        return null;
    }

    public static TourLeader searchByLastName(ArrayList<TourLeader> tourLeaders, String lastName) {
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).lastName.equals(lastName)) {
                return tourLeaders.get(i);
            }
        }
        return null;
    }

    public static TourLeader searchByNationalCode(ArrayList<TourLeader> tourLeaders, String nationalCode) {
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).nationalCode.equals(nationalCode)) {
                return tourLeaders.get(i);
            }
        }
        return null;
    }

    public static ArrayList<TourLeader> searchByArea(ArrayList<TourLeader> tourLeaders, String name) {
        ArrayList<TourLeader> wanted = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            for (Area area : tourLeader.getAreas()) {
                if (area.getName().equalsIgnoreCase(name)) {
                    wanted.add(tourLeader);
                    break;
                }
            }
        }
        return wanted;
    }

    public static ArrayList<TourLeader> searchByAge(ArrayList<TourLeader> tourLeaders, int age, Date today) {
        ArrayList<TourLeader> wanted = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (tourLeader.getDOB().ageCalculator(today) == age) {
                wanted.add(tourLeader);
            }
        }
        return wanted;
    }

    public static ArrayList<TourLeader> searchOlderThan(ArrayList<TourLeader> tourLeaders, int age, Date today) {
        ArrayList<TourLeader> wanted = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (tourLeader.getDOB().ageCalculator(today) > age) {
                wanted.add(tourLeader);
            }
        }
        return wanted;
    }

    public static ArrayList<TourLeader> searchYoungerThan(ArrayList<TourLeader> tourLeaders, int age, Date today) {
        ArrayList<TourLeader> wanted = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (tourLeader.getDOB().ageCalculator(today) < age) {
                wanted.add(tourLeader);
            }
        }
        return wanted;
    }

    public static ArrayList<TourLeader> searchBetween2Ages(ArrayList<TourLeader> tourLeaders, int age1, int age2, Date today) {
        ArrayList<TourLeader> wanted = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (tourLeader.getDOB().ageCalculator(today) > age1 && tourLeader.getDOB().ageCalculator(today) < age2) {
                wanted.add(tourLeader);
            }
        }
        return wanted;
    }
}
