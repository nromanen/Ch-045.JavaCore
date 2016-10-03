package net.gavrilyuk.talks;

import java.util.Scanner;

/**
 *
 * Created by GipSoft on 28.09.2016.
 */
public class AppTalks {


    private static final int TALKS_COUNT = 3; //calls  count

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Talks allTalks = new Talks();
        for (int i = 0; i < TALKS_COUNT; i++) {
            Talk talkToCountry = new Talk();
            Country c = new Country();
            c.setName(TalkUtil.getCountryName(i));
            double cost = TalkUtil.readDouble(scanner, "coast of", TalkUtil.getCountryName(i));
            c.setCostOfMinute(cost);
            talkToCountry.setToCountry(c);
            double duration = TalkUtil.readDouble(scanner, "duration (minutes)", TalkUtil.getCountryName(i));
            talkToCountry.setDuration(duration);
            allTalks.getTalks().add(talkToCountry);
        }
        scanner.close();
        System.out.println(allTalks.showTalks());
    }
}
