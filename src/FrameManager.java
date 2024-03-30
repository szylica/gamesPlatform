import java.util.ArrayList;

import javax.swing.JFrame;


//HELPER CLASS
public class FrameManager {
    private static ArrayList<JFrame> frames = new ArrayList<>();

    public static void addFrame(JFrame frame) {
        frames.add(frame);
    }

    public static void removeFrame(JFrame frame) {
        frames.remove(frame);
    }

    public static void closeAllFrames() {
        for (int i = 0; i < frames.size(); i++) {
            frames.get(i).dispose(); // Zamykanie okien
        }
    }
}
