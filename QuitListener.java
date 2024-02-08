import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Runnable r1 = () -> System.exit(0);
        r1.run();
    }
}