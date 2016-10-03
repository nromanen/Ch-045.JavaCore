package net.gavrilyuk.talks;

import java.util.ArrayList;

/**
 *
 * Created by Igor Gavryliuk on 30.09.2016.
 */
public class Talks {

    private final ArrayList<Talk> talks;
    private double totalDuration ;
    private double totalCostOf ;

    public Talks() {
        talks = new ArrayList<>();
    }

    public ArrayList<Talk> getTalks() {
        return talks;
    }

    public void setTalks(ArrayList<Talk> talks) {
        talks = talks;
    }

    public String showTalks() {
        StringBuilder builder = new StringBuilder();
        builder.append("---------------------------------------------------------").append("\n");
        if (talks.size() > 0) {
            for (Talk talk : talks) {
                builder.append(talk.getTalkString()).append("\n");
                totalDuration += talk.getDuration();
                totalCostOf += talk.getPrice();
            }
            builder.append("---------------------------------------------------------").append("\n");
            builder.append("Total cals duration=").append(TalkUtil.getDurationToString(totalDuration)).append(" | Total cost of=").append(String.format("%,.2f", totalCostOf)).append(" unit");
        } else {
            builder.append("Calls list is empty"+"\n");
            builder.append("---------------------------------------------------------").append("\n");
        }
        return builder.toString();
    }
}
