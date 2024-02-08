import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

class CenteredFrame extends JFrame
{
    public CenteredFrame()
    {
        // get screen dimensions

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // center frame in screen

        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);

        // set frame icon and title

        Image img = kit.getImage("icon.gif");
        setIconImage(img);
        setTitle("CenteredFrame");
        JPanel mainPnl, topPnl, centerPnl, bottomPnl;
        //Need help with image won't display and can't have caption
        setTitle("My Fortune Teller");
        JLabel titlelable = new JLabel("My Fortune Teller");
        ImageIcon icon = new ImageIcon("src/free-clip-art-fortune-teller-4.png","Fortune teller");
        Image image = icon.getImage(); // transform it
        Image newimg = image.getScaledInstance(180, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon iconDisplay = new ImageIcon(newimg);
        JLabel iconShow = new JLabel(iconDisplay);
        titlelable = new JLabel("My Fortune Teller", iconDisplay, JLabel.CENTER);
        titlelable.setFont(new Font("Papyrus", Font.PLAIN, 36));
        // Obscure code to align the text to the Icon!
        titlelable.setVerticalTextPosition(JLabel.BOTTOM);
        titlelable.setHorizontalTextPosition(JLabel.CENTER);
        JButton quitBtn = new JButton("Quit");
        JButton readFortune = new JButton("Read Fortune");
        JButton itemAdderBtn = new JButton("Add item:");
        JTextArea textArea = new JTextArea(15,30);
        Font font = new Font("Papyrus", Font.PLAIN, 20);
        textArea.setFont(font);
        JScrollPane scroller = new JScrollPane(textArea);
        QuitListener listener = new QuitListener();
        quitBtn.addActionListener(listener);
        mainPnl = new JPanel();
        topPnl = new JPanel();
        centerPnl = new JPanel();
        bottomPnl = new JPanel();
        //stored array of fortunes
        ArrayList<String> fortunes = new ArrayList<>();
        Random rand = new Random();
        final int[] curFortuneDex = {-1};
        fortunes.add("You will find a penny");
        fortunes.add("You will drink a soda");
        fortunes.add("You will be elected president");
        fortunes.add("You will eat a big burger");
        fortunes.add("You will have a nice dream");
        fortunes.add("You will run a marathon");
        fortunes.add("You will be loved forever");
        fortunes.add("You will see in the dark");
        fortunes.add("You will get super strength");
        fortunes.add("You will become filthy rich");
        fortunes.add("You will jump high");
        fortunes.add("You will break a world record");
        class ItemListener implements ActionListener
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                String newItem;

                newItem = JOptionPane.showInputDialog(mainPnl,"Item:","Enter an New Item",JOptionPane.QUESTION_MESSAGE);

                if(newItem.length() > 0)
                    textArea.append(newItem + "\n");
            }

        }
        class FortuneList implements ActionListener {
            //Need help with non-repeating fortune
            @Override
            public void actionPerformed(ActionEvent e) {
                int chosenFortune = -1;
                do
                {
                    chosenFortune = rand.nextInt(12);
                }while(chosenFortune == curFortuneDex[0]);
                textArea.append(fortunes.get(chosenFortune));
                curFortuneDex[0] = chosenFortune;
                textArea.append("\n");
            }
        }


        add(mainPnl);

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(topPnl, BorderLayout.NORTH);
        topPnl.add(titlelable);
        mainPnl.add(centerPnl, BorderLayout.CENTER);
        centerPnl.add(scroller);
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);
        bottomPnl.setLayout(new GridLayout(1,3));
        itemAdderBtn.addActionListener(new ItemListener());
        bottomPnl.add(readFortune);
        readFortune.addActionListener(new FortuneList());
        bottomPnl.add(quitBtn);

        setVisible(true);
    }
}

