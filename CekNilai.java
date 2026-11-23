package TUGAS3_PBO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CekNilai extends JFrame { // 1. Top-level Container (JFrame)

    public CekNilai() {
        setTitle("Konversi Nilai Mahasiswa");
        setSize(340, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 4. Layout Class 
        setLayout(new BorderLayout(20, 20));

        // 2. Intermediate Container (JPanel) dan Layout 
        JPanel panelUtama = new JPanel(new GridLayout(3, 2, 8, 8));
        panelUtama.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));

        // Intermediate Container 2 dan Layout 
        JPanel panelBawah = new JPanel(new FlowLayout());

        // 3. Atomic Components
        JTextField Nilai = new JTextField();
        JLabel Grade = new JLabel("-");
        JLabel Status = new JLabel("-");
        JButton btnCek = new JButton("Cek Hasil");

        panelUtama.add(new JLabel("Nilai Angka (0-100):"));
        panelUtama.add(Nilai);
        panelUtama.add(new JLabel("Nilai Huruf:"));
        panelUtama.add(Grade);
        panelUtama.add(new JLabel("Status:"));
        panelUtama.add(Status);

        panelBawah.add(btnCek);

        // 5. Event Listener 
        btnCek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double n = Double.parseDouble(Nilai.getText());
                    if (n < 0 || n > 100) {
                        JOptionPane.showMessageDialog(null, "Masukkan angka 0 - 100!");
                        return;
                    }

                    String grade;
                    if (n >= 80) {
                        grade = "A";
                    } else if (n >= 70) {
                        grade = "B";
                    } else if (n >= 60) {
                        grade = "C";
                    } else if (n >= 50) {
                        grade = "D";
                    } else {
                        grade = "E";
                    }

                    String status;
                    if (n >= 60) {
                        status = "LULUS";
                    } else {
                        status = "TIDAK LULUS";
                    }

                    Grade.setText(grade);
                    Status.setText(status);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus berupa angka!");
                }
            }
        });

        add(panelUtama, BorderLayout.CENTER);
        add(panelBawah, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CekNilai().setVisible(true));
    }
}