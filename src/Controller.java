import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class Controller {
//

    Model model;
    View view;

    Controller(Model model , View view) {
        this.model = model;
        this.view = view;

        public JPanel conteneur_table() {
            JPanel container = new JPanel();
            JScrollPane scrollPane = new JScrollPane(view.createTable());
            view.createTable().setFillsViewportHeight(true);
            container.setLayout(new BorderLayout());
            container.add(view.createTable(), "Center");
            container.add(scrollPane);
            view.add(this.createTable1());
            view.add(this.conteneur_table());
            return container;
        }

        public JPanel conteneur_graPHE() {
            DefaultCategoryDataset dataset = view.createDataset();
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
        public JPanel conteneur_table1() {
            JPanel container = new JPanel();
            JScrollPane scrollPane = new JScrollPane(view.createTable());
            view.createTable().setFillsViewportHeight(true);
            container.setLayout(new BorderLayout());
            container.add(view.createTable1(), "Center");
            container.add(scrollPane);
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



        public String[] createTableHeader() {
            String[] head = new String[]{"Nom", "PreNom", "AL1", "AL2", "AL3"};
            return head;
        }

        public String[][] createTableBody(model.getPrenom(), model.nom, model.AL1, model.AL2, model.globalNote) {
            String[][] donnees = {
                    {"Johnathan", "Sykes", "18", "26", "44"},
                    {"Nicolas", "Jamie", "18", "26", "44"},
                    {"Damien", "Cuthbert", "18", "26", "44"},
                    {"Corinne", "Valance", "18", "26", "44"},
                    {"Emilie", "Schrödinger", "18", "26", "44"},
                    {"Delphine", "Duke", "18", "26", "44"},
                    {"Eric", "Trump" , "18", "26", "44"},
            };

            return donnees;
        }



        public JTable createTable() {
            JTable table = new JTable(view.createTableBody(model.getprenom(), model.getnom(), model.getAL1(), model.getAL2(), model.getAL3()), view.createTableHeader());

            return table;
        }





        public JTable createTable1() {
            String[][] donnees = {
                    {"Property Name","Property Value"},
                    {"Datetime", "8/29/2021 10:12:12"},
                    {"Name", "Log/2018/2017/09/l3"},
            };
            String column[]={"Property Name","Property Value"};
            JTable table = new JTable(donnees, column);
            return table;
        }




    }





}
