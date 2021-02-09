package czynnosciowe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/*Biblioteka javy zawiera już predefiniowany interfejs observer.
 *jednak interfejs tego obserwatora nie jest doskonały i
 * przestarzały od wersji java9. Jedną z jego wad jest to
 * że Observable nie jest interfejsem,ale klasą, dlatego
 * podklasy nie mogą być używane jako obserwowalne.
 * Zaleca się stosować interfejs ProperyChangeListener */

class MessageBean {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private String message; // the bean  property

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String newValue) {
        String oldValue = this.message;
        this.message = newValue;
        support.firePropertyChange("message", oldValue, newValue);
    }
}

public class Obserwator_Main {

    public Obserwator_Main() {

        JFrame frame = new JFrame("Frame-1");
        final JLabel label = new JLabel("Observing...");
        label.setFont(new Font("Dialog", Font.PLAIN, 18));
        frame.add(label);
        frame.getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 150);
        frame.setLocation(200, 200);
        frame.setVisible(true);

        MessageBean bean = new MessageBean();
        bean.addPropertyChangeListener(e ->
                label.setText((String) e.getNewValue())
        );

        // Open the second window
        new Frame2(bean);
    }

    public static void main(String[] args) {

        new Obserwator_Main();
    }
}

class Frame2 {

    private int clicks;

    public Frame2(MessageBean bean) {

        JFrame frame = new JFrame("Frame-2");
        JLabel label = new JLabel("Click anywhere to fire a property change event");
        label.setFont(new Font("Dialog", Font.PLAIN, 18));
        frame.add(label);
        frame.getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 150);
        frame.setLocation(600, 200);
        frame.setVisible(true);

        // A click event on the frame triggers the bean property
        // change from this mouse listener.
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String data = "Click-count [" + ++clicks + "]";
                // The bean's changed property notifies
                // the registered observer
                bean.setMessage(data);
            }
        });
    }
}