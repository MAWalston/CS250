import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

    private static final long serialVersionUID = 1L;
    
    private JPanel slidePane;
    private JPanel textPane;
    private JPanel buttonPane;
    private CardLayout card;
    private CardLayout cardText;
    private JButton btnPrev;
    private JButton btnNext;
    private JLabel lblSlide;
    private JLabel lblTextArea;

    public SlideShow() throws HeadlessException {
        initComponent();
    }

    private void initComponent() {
        card = new CardLayout();
        cardText = new CardLayout();
        slidePane = new JPanel();
        textPane = new JPanel();
        textPane.setBackground(Color.BLUE);
        textPane.setLayout(null);
        textPane.setBounds(5, 470, 790, 50);
        textPane.setVisible(true);
        buttonPane = new JPanel();
        btnPrev = new JButton();
        btnNext = new JButton();
        lblSlide = new JLabel();
        lblTextArea = new JLabel();

        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Top 5 Destinations SlideShow");
        getContentPane().setLayout(new BorderLayout(10, 50));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        slidePane.setLayout(card);
        textPane.setLayout(cardText);

        for (int i = 1; i <= 5; i++) {
            lblSlide = new JLabel();
            lblTextArea = new JLabel();
            lblSlide.setText(getResizeIcon(i)); // Use the modified method to get the image
            lblTextArea.setText(getTextDescription(i));
            slidePane.add(lblSlide, "card" + i);
            textPane.add(lblTextArea, "cardText" + i);
        }

        getContentPane().add(slidePane, BorderLayout.CENTER);
        getContentPane().add(textPane, BorderLayout.SOUTH);

        buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        btnPrev.setText("Previous");
        btnPrev.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                goPrevious();
            }
        });
        buttonPane.add(btnPrev);

        btnNext.setText("Next");
        btnNext.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                goNext();
            }
        });
        buttonPane.add(btnNext);

        getContentPane().add(buttonPane, BorderLayout.SOUTH);
    }

    private void goPrevious() {
        card.previous(slidePane);
        cardText.previous(textPane);
    }

    private void goNext() {
        card.next(slidePane);
        cardText.next(textPane);
    }

    /**
     * Method to get the images for TestImage1 to TestImage5 in their respective slides
     */
    private String getResizeIcon(int i) {
        String image = "";
        String imageName = "TestImage" + i + ".jpg"; // Construct the image name based on i
        // Load the image for the current slide
        image = "<html><body><img width='800' height='500' src='" + getClass().getResource("/resources/" + imageName) + "'></body></html>";
        return image;
    }

    private String getTextDescription(int i) {
        String text = "";
        if (i == 1) {
            text = "<html><body><font size='5'>#1 The Grand Canyon.</font> <br>Spectacular canyon views and hiking.</body></html>";
        } else if (i == 2) {
            text = "<html><body>#2 Top Destination</body></html>";
        } else if (i == 3) {
            text = "<html><body>#3 Top Destination</body></html>";
        } else if (i == 4) {
            text = "<html><body>#4 Top Destination</body></html>";
        } else if (i == 5) {
            text = "<html><body>#5 Top Destination</body></html>";
        }
        return text;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                SlideShow ss = new SlideShow();
                ss.setVisible(true);
            }
        });
    }
}
