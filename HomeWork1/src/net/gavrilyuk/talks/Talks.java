package net.gavrilyuk.talks;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Igor Gavryliuk on 30.09.2016.
 */
public class Talks {

    private final List<Talk> talks;
    private double totalDuration ;
    private double totalCostOf ;

    public Talks() {
        talks = new ArrayList<>();
    }

    public List<Talk> getTalks() {
        return talks;
    }



    public String showTalks() {
        StringBuilder builder = new StringBuilder();
        if ( talks.size() > 0) {
            for (Talk talk : talks) {
                builder.append(talk.getTalkString()).append("\n");
                totalDuration += talk.getDuration();
                totalCostOf += talk.getPrice();
            }

            builder.append("Total cals duration=").append(TalkUtil.getDurationToString(totalDuration)).append(" | Total cost of=").append(String.format("%,.2f", totalCostOf)).append(" unit");
        } else {
            builder.append("Calls list is empty"+"\n");

        }
        return builder.toString();
    }
}
