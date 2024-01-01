import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JasaCuciSepatu extends JFrame {

    private JTextField namaPelangganField, jumlahSepatuField;
    private JTextArea hasilArea;

    private ArrayList<PesananCuciSepatu> daftarPesanan;

    public JasaCuciSepatu() {
        setTitle("Aplikasi Jasa Cuci Sepatu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        daftarPesanan = new ArrayList<>();

        JLabel labelNama = new JLabel("Nama Pelanggan:");
        namaPelangganField = new JTextField(20);

        JLabel labelJumlahSepatu = new JLabel("Jumlah Sepatu:");
        jumlahSepatuField = new JTextField(5);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitPesanan();
            }
        });

        hasilArea = new JTextArea();
        hasilArea.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(labelNama);
        panel.add(namaPelangganField);
        panel.add(labelJumlahSepatu);
        panel.add(jumlahSepatuField);
        panel.add(new JLabel());  // Cell filler
        panel.add(submitButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(hasilArea), BorderLayout.CENTER);
    }

    private void submitPesanan() {
        String namaPelanggan = namaPelangganField.getText();
        int jumlahSepatu = Integer.parseInt(jumlahSepatuField.getText());

        PesananCuciSepatu pesanan = new PesananCuciSepatu(namaPelanggan, jumlahSepatu);
        daftarPesanan.add(pesanan);

        updateHasil();
        clearInputFields();
    }

    private void updateHasil() {
        hasilArea.setText("Daftar Pesanan Jasa Cuci Sepatu:\n");

        for (PesananCuciSepatu pesanan : daftarPesanan) {
            hasilArea.append(pesanan.toString() + "\n");
        }

        hasilArea.append("\nTotal Biaya: " + hitungTotalBiaya() + " Rupiah");
    }

    private int hitungTotalBiaya() {
        int total = 0;
        for (PesananCuciSepatu pesanan : daftarPesanan) {
            total += pesanan.hitungBiaya();
        }
        return total;
    }

    private void clearInputFields() {
        namaPelangganField.setText("");
        jumlahSepatuField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JasaCuciSepatu().setVisible(true);
            }
        });
    }
}
