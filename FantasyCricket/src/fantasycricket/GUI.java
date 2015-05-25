/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasycricket;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Sunildev Birbal
 * @registration number 12/0719/2653
 */
public class GUI implements ActionListener {

    //instantiating objects
    private final JFrame main = new JFrame();
    private final JPanel playerInfo = new JPanel();
    private final JPanel status = new JPanel();
    private final JTextArea sqlQueryText = new JTextArea();
//    private final JFrame sqlquery = new JFrame();
//    private final JButton pfname = new JButton();
//    private final JButton plname = new JButton();
//    private final JButton pteam = new JButton();
//    private final JButton prole = new JButton();
//    private final JButton pbats = new JButton();
//    private final JButton pbowls = new JButton();
//    private final JButton test = new JButton();
//    private final JButton pnationality = new JButton();
    private final JButton update = new JButton();
    private final JButton sqllink = new JButton();
    private static final JPanel playerinfo = new JPanel();
//    private int i;
//    private final JMenu topmenu = new JMenu();
    private final MySQL sql;
    private final Cricketer cricketer = new Cricketer();
    private String query;
    private int maxplayers;
    private ResultSet data;

    public GUI() throws SQLException {
        this.sql = new MySQL();
    }

    public void MainGUI() throws SQLException {
        GetIndexValue();
        sqllink.setText("Update SQL Query");
        sqllink.addActionListener(this);
        main.setLayout(new GridBagLayout());
        main.add(sqllink);

        main.setSize(700, 500);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        main.setVisible(true);

    }

    public void PlayerCard(int i) throws SQLException, IOException {
        cricketer.setId(i);
        //playerInfo.add(cricketer.CricketerCard());
        
        
        main.add(cricketer.CricketerCard());
        main.validate();

    }

   

    public void GetIndexValue() throws SQLException {
        try {
            sql.Connect();
            sql.setResults("SELECT MAX(ID) AS maxindex FROM cricketersinfo");
            this.data = sql.getResult();

            while (data.next()) {
                maxplayers = Integer.parseInt(data.getString("maxindex"));
                //System.out.println(maxplayers);
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql.CloseConn();

    }

    public void Player() {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (ae.getSource() == sqllink) {
            System.out.println("Pressed");
            try {
                //            try {
                   for (int i = 1; i <=11; i++) {
                       PlayerCard(i);
//
                 }
//            } catch (SQLException ex) {
//                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//            }
            } catch (SQLException | IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (ae.getSource() == update) {
            System.out.println("Pressed");
            query = sqlQueryText.getText();

            try {
                sql.setStatement(query);
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
