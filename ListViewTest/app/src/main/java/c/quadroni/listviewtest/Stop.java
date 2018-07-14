package c.quadroni.listviewtest;

import android.icu.text.SimpleDateFormat;
import android.util.Log;

import java.util.Date;

public class Stop {
    String departure;

    String getDepartureTime(){
        // 2018-07-05T18:03:00+0200
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+0200'");
        try {
            Date date = format.parse(departure);
            return String.format("%tR", date);
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage().toString());
            return "Fehler";
        }
    }
}
