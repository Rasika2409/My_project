import java.awt.*;
import javax.swing.*;

public class StudentGradeCalculatorGUI {

    private JFrame frame;
    private JTextField subjectCountField;
    private JPanel marksPanel;
    private JTextField[] marksFields;

    public StudentGradeCalculatorGUI() {
        frame = new JFrame("Student Grade Calculator");
        frame.setSize(450, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter number of subjects: ");
        subjectCountField = new JTextField(5);
        JButton generateButton = new JButton("Generate");

        topPanel.add(label);
        topPanel.add(subjectCountField);
        topPanel.add(generateButton);

        frame.add(topPanel, BorderLayout.NORTH);

        marksPanel = new JPanel();
        marksPanel.setLayout(new GridLayout(0, 2, 10, 10));
        frame.add(new JScrollPane(marksPanel), BorderLayout.CENTER);

        
        JButton calcButton = new JButton("Calculate Grade");
        frame.add(calcButton, BorderLayout.SOUTH);

      
        generateButton.addActionListener(e -> generateFields());

        
        calcButton.addActionListener(e -> calculateGrade());

        frame.setVisible(true);
    }

    private void generateFields() {
        try {
            int count = Integer.parseInt(subjectCountField.getText());
            marksPanel.removeAll(); 

            marksFields = new JTextField[count];

            for (int i = 0; i < count; i++) {
                marksPanel.add(new JLabel("Subject " + (i + 1) + " Marks:"));
                marksFields[i] = new JTextField();
                marksPanel.add(marksFields[i]);
            }

            marksPanel.revalidate();
            marksPanel.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
        }
    }

    private void calculateGrade() {
        try {
            int total = 0;

            for (JTextField field : marksFields) {
                int marks = Integer.parseInt(field.getText());
                total += marks;
            }

            double average = total / (double) marksFields.length;
            char grade;

            if (average >= 90) grade = 'A';
            else if (average >= 75) grade = 'B';
            else if (average >= 60) grade = 'C';
            else if (average >= 45) grade = 'D';
            else grade = 'F';

            JOptionPane.showMessageDialog(frame,
                    "Total Marks: " + total +
                    "\nAverage: " + average +
                    "\nGrade: " + grade,
                    "Result",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid marks for all subjects!");
        }
    }

    public static void main(String[] args) {
        new StudentGradeCalculatorGUI();
    }
}