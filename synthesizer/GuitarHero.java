package synthesizer;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    private static final double CONCERT_A = 440.0;
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
        GuitarString[] strings = new GuitarString[37];

        for(int i = 0; i < strings.length; i++) {
            strings[i] = new GuitarString(Math.pow(2, (i - 12) / 12) * 440);
        }

        while(true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if(index != -1) {
                    strings[index].pluck();
                }

            }

            /* compute the superposition of samples */
            double sample = 0;
            for(GuitarString s : strings) {
                sample += s.sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for(GuitarString s : strings) {
                s.tic();
            }
        }
    }
}
