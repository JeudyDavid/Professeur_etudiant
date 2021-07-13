import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class View {


    public JMenu first = new JMenu("Files");
    public JMenu second = new JMenu("Modes");
    public JMenu third = new JMenu("Option");
    public JMenu fauth = new JMenu("Help");
    public JLabel Titre1 = new JLabel("GUI Demo");
    public JLabel Titre2 = new JLabel("  .LabVIEW");
    public JButton Titre3 = new JButton("ACQUIRE");
    public JButton Titre4 = new JButton("EXPLORE");
    public JButton Titre5 = new JButton("PRESENT");



    public View() {
        JFrame fenetre = new JFrame();
        fenetre.setDefaultCloseOperation(3);
        fenetre.setLocationRelativeTo((Component)null);
        fenetre.setJMenuBar(this.menu());
        Container contentPane = fenetre.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(this.titrePrinc(), "North");
        contentPane.add(this.listeBouton(), "West");
        JPanel mainPanel1 = new JPanel();
        mainPanel1.setLayout(new GridLayout(2, 1));
        mainPanel1.add(this.tree());

        contentPane.add(mainPanel1, "East");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));
        mainPanel.add(this.conteneur_graPHE());

        contentPane.add(mainPanel);
        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setSize(1380, 1000);
    }

    public JPanel listeBouton() {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, 1));
        container.add(this.Titre3);
        this.Titre3.setPreferredSize(new Dimension(100, 70));
        container.add(this.Titre4);
        this.Titre4.setPreferredSize(new Dimension(100, 70));
        container.add(this.Titre5);
        this.Titre5.setPreferredSize(new Dimension(100, 70));
        container.add(this.divider());
        container.add(this.Titre2);
        return container;
    }

    public JPanel divider() {
        JPanel container = new JPanel();
        return container;
    }

    public JPanel titrePrinc() {
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(0));
        container.setBackground(Color.blue);
        container.add(this.Titre1);
        this.Titre1.setFont(new Font((String)null, 0, 30));
        this.Titre1.setForeground(Color.WHITE);
        return container;
    }




    public JPanel conteneur_graPHE() {
        DefaultCategoryDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createLineChart(
                "Graph",
                "Samples",
                "Amplitude",
                dataset
        );
        ChartPanel panel = new ChartPanel(chart);
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(panel, "East");

        return container;
    }


    public JPanel tree() {
        JPanel container = new JPanel();
        DefaultMutableTreeNode style=new DefaultMutableTreeNode("Note_2021_NOTE_ESIH_EDU_BACHELOR");
        DefaultMutableTreeNode note=new DefaultMutableTreeNode("note");

        style.add(note);
        DefaultMutableTreeNode red=new DefaultMutableTreeNode("Al1");
        DefaultMutableTreeNode blue=new DefaultMutableTreeNode("Al2");
        DefaultMutableTreeNode black=new DefaultMutableTreeNode("Al3");

        note.add(red); note.add(blue); note.add(black);
        JTree jt=new JTree(style);
        container.setLayout(new BorderLayout());
        container.add(jt, "East");
        return container;
    }




    private DefaultCategoryDataset createDataset() {

        String series1 = "Distribution";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(20, series1, "0");
        dataset.addValue(0, series1, "50");
        dataset.addValue(5, series1, "100");
        dataset.addValue(20, series1, "150");
        dataset.addValue(5, series1, "200");
        dataset.addValue(20, series1, "250");
        dataset.addValue(0, series1, "300");

        dataset.addValue(-5, series1, "350");
        dataset.addValue(0, series1, "450");
        dataset.addValue(20, series1, "500");
        dataset.addValue(0, series1, "550");
        dataset.addValue(-20, series1, "600");
        dataset.addValue(-20, series1, "650");
        dataset.addValue(0, series1, "700");

        return dataset;
    }



    public JMenuBar menu() {
        JMenuBar menubar = new JMenuBar();
        menubar.add(this.first);
        menubar.add(this.second);
        menubar.add(this.third);
        menubar.add(this.fauth);
        return menubar;
    }
}
