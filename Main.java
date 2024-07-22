import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;

public class Linklist {
    static JFrame frame;
    static JTextField text;
    static JRadioButton r1, r2;
    static JButton b1, b2, b3, b4;
    static JLabel l1, l2;
    static LinkedList<Integer> list;

    // Methods to Implement ADD,DELETE,PUSH,POP Operations in Queue and Stack
    // respectively
    public static void Add(int i) {
        list.offer(i);
    }

    public static void Delete() {
        list.poll();
    }

    public static void Push(int i) {
        list.add(i);
    }

    public static void Pop() {
        list.removeLast();
    }

    // Methods to get elements of the list in 'String Format'
    public static String elements() {
        String input = " ";
        for (int i = 0; i < list.size(); i++) {
            input += list.get(i) + " ";
        }
        return input;
    }

    public static void main(String[] args) {

        list = new LinkedList<>();// Linked List creation
        Random random = new Random();// To Generate Random numbers

        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(200));
        }

        // To initialise JFrame
        frame = new JFrame("STACK AND QUEUE IMPLEMENTATION USING GUI");
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // To initialise and Add JLabel2
        l1 = new JLabel("LIST: ");
        l1.setBounds(40, 25, 150, 30);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        frame.add(l1);

        // To initialise and Add JLabel2
        l2 = new JLabel("SELECT OPERATION: ");
        l2.setBounds(40, 150, 300, 50);
        l2.setFont(new Font("Times New Roman", Font.BOLD, 24));
        frame.add(l2);

        // To initialise and Add JTextField
        text = new JTextField();
        text.setBounds(50, 60, 300, 50);
        text.setText(elements());
        frame.add(text);

        // To initialise and Add JRadioButton 1
        r1 = new JRadioButton("STACK");
        r1.setBounds(50, 200, 75, 50);
        frame.add(r1);

        // To initialise and Add JRadioButton 2
        r2 = new JRadioButton("QUEUE");
        r2.setBounds(200, 200, 75, 50);
        frame.add(r2);

        // To initialise and Add JButton 1,2,3,4
        b1 = new JButton("PUSH");
        b1.setBounds(85, 250, 100, 30);
        b1.addActionListener(new A1());
        frame.add(b1);

        b2 = new JButton("POP");
        b2.setBounds(85, 300, 100, 30);
        b2.addActionListener(new A2());
        frame.add(b2);

        b3 = new JButton("ADD");
        b3.setBounds(85, 350, 100, 30);
        b3.addActionListener(new A3());
        frame.add(b3);

        b4 = new JButton("DELETE");
        b4.setBounds(85, 400, 100, 30);
        b4.addActionListener(new A4());
        frame.add(b4);

        frame.setVisible(true);
    }

    // Action Listener for PUSH button
    static class A1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String t = JOptionPane.showInputDialog(this, "Enter a Number");
            if (r1.isSelected()) {
                try {
                    int x = Integer.parseInt(t);
                    list.addFirst(x);
                    JOptionPane.showMessageDialog(frame, "ELEMENT PUSHED INTO THE STACK");
                    text.setText(elements());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(frame, "INVALID INPUT");
                    text.setText(elements());
                }
            } else if (r2.isSelected()) {
                JOptionPane.showMessageDialog(frame, "PUSH OPERATION CANNOT BE DONE ON QUEUE");
                text.setText(elements());
            } else {
                JOptionPane.showMessageDialog(frame, "INVALID SELECTION");
            }
        }
    }

    // Action Listener for POP button
    static class A2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r1.isSelected()) {
                if (list.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "CANNOT POP AN ELEMENT FROM AN EMPTY STACK");
                }

                else {
                    list.removeFirst();
                    text.setText(elements());
                    JOptionPane.showMessageDialog(frame, "ELEMENT POPPED FROM STACK");
                }
            } else if (r2.isSelected()) {
                JOptionPane.showMessageDialog(frame, "POP OPERATION CANNOT BE DONE ON QUEUE");
                text.setText(elements());
            } else {
                JOptionPane.showMessageDialog(frame, "INVALID SELECTION");
            }
        }
    }

    // Action Listener for ADDbutton
    static class A3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String t = JOptionPane.showInputDialog(this, "Enter a Number");
            if (r2.isSelected()) {
                try {
                    int x = Integer.parseInt(t);
                    list.addLast(x);
                    text.setText(elements());
                    JOptionPane.showMessageDialog(frame, "ELEMENT ADDED TO QUEUE");
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(frame, "INVALID INPUT");
                    text.setText(elements());
                }
            } else if (r1.isSelected()) {
                JOptionPane.showMessageDialog(frame, "ADD OPERATION CANNOT BE DONE ON STACK");
                text.setText(elements());
            } else {
                JOptionPane.showMessageDialog(frame, "INVALID SELECTION");
            }
        }
    }

    // Action Listener for DELETE button
    static class A4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (r2.isSelected()) {
                if (list.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "CANNOT DELETE AN ELEMENT FROM AN EMPTY QUEUE");
                }

                else {
                    list.removeFirst();
                    text.setText(elements());
                    JOptionPane.showMessageDialog(frame, "ELEMENT DELETED FROM QUEUE");
                }
            } else if (r1.isSelected()) {
                JOptionPane.showMessageDialog(frame, "DELETE OPERATION CANNOT BE DONE ON STACK");
                text.setText(elements());
            } else {
                JOptionPane.showMessageDialog(frame, "INVALID SELECTION");
            }
        }
    }
}
