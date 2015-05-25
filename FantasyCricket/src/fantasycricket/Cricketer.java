/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasycricket;

import static fantasycricket.Cricketer.ScaledImageIcon;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

/**
 * @author Sunildev Birbal
 * @registration number 12/0719/2653
 */
public class Cricketer extends JList {

    private final MySQL sql = new MySQL();
    private ResultSet cricketerstat;
    private String playerfname;
    private String playerlname;
    private String playerteam;
    private String playerrole;
    private String playernationality;
    private int playerid;
    private String bats;
    private String bowls;
    private String picURL;
    private ImageIcon cricketerPic;
    private final BufferedImage img = null;
    private Image resized;
    private final JLabel picture = new JLabel();
    private final JPanel playerStats = new JPanel();
    private final JPanel playerPic = new JPanel();
    private int id;
    private final JPanel cricketer = new JPanel();
    private final GridLayout layout = new GridLayout();
    private JPanel jp1 = new JPanel();
    private JPanel jp2 = new JPanel();
    private JPanel jp3 = new JPanel();
    private final JPanel panel = new JPanel();
    Vector vector = new Vector();

    public Cricketer() {
        setCellRenderer(new CustomCellRenderer());
    }

    public void PlayerBio() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {
        //sql.Connect();
        sql.setResults("SELECT * FROM cricketersinfo where ID =" + id);

        this.cricketerstat = sql.getResult();
        while (cricketerstat.next()) {
            this.playerfname = cricketerstat.getString("FirstName");
            this.playerlname = cricketerstat.getString("LastName");
            this.playerteam = cricketerstat.getString("Team");
            this.playerrole = cricketerstat.getString("Role");
            this.playernationality = cricketerstat.getString("Nationality");
            this.playerid = Integer.parseInt(cricketerstat.getString("ID"));
            this.bats = cricketerstat.getString("Bats");
            this.bowls = cricketerstat.getString("Bowls");
            this.picURL = "res/csk/" + cricketerstat.getString("ID") + ".png";
        }
        this.cricketerPic = ScaledImageIcon(this.picURL, 70, 80, this.picURL);
        this.picture.setIcon(cricketerPic);

    }

    public JPanel CricketerCard() throws IOException {
        //  img = ImageIO.read(new File(picURL));
//        jp2.setLayout(new BoxLayout(jp2, BoxLayout.X_AXIS));   // NEW
//        jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
//        jp3.setForeground(Color.yellow);
//        jp3.setBackground(Color.white);
//      
//
//        Cricketer jlwi = new Cricketer();
//        jlwi.setListData(vector);
//        jlwi.setBorder(new LineBorder(Color.red));
//        playerStats.setLayout(new BoxLayout(playerStats, BoxLayout.Y_AXIS));
//        playerPic.setLayout(new BoxLayout(playerPic, BoxLayout.Y_AXIS));
//
//        jp1.add(new JLabel(new ImageIcon(picURL)));
//
//        jp2.add(new JLabel("Player Name: " + playerfname + " " + playerlname));
//        jp2.add(new JLabel("Team: " + playerteam));
//        jp2.add(new JLabel("Role/s: " + playerrole));
//        jp2.add(new JLabel("Nationality: " + playernationality));
//        jp2.add(new JSeparator());
//        jp1.add(jp2);
//
//        // cricketer.setLayout(layout);
////        cricketer.setSize(300, 200);
////        playerStats.add(new JLabel("Player Name: " + playerfname + " " + playerlname));
////        playerStats.add(new JLabel("Team: " + playerteam));
////        playerStats.add(new JLabel("Role/s: " + playerrole));
////        playerStats.add(new JLabel("Nationality: " + playernationality));
////        playerStats.add(new JSeparator());
////        playerPic.add(picture);
////        playerPic.add(new JSeparator());
//        // cricketer.add(playerPic);

       // panel.setForeground(Color.red);
        // panel.setBackground(Color.white);
        // first line
        jp1 = new JPanel();
        jp3 = new JPanel();
        jp3.setBackground(Color.white);
        jp1.setBackground(Color.white);
        jp3.setLayout(new BoxLayout(jp3, BoxLayout.Y_AXIS));   // NEW
        jp1.setLayout(new BoxLayout(jp1, BoxLayout.X_AXIS));   // NEW
        jp1.add(new JLabel(cricketerPic));
        jp3.add(new JLabel("Player Name: " + playerfname + " " + playerlname));
        jp3.add(new JLabel("Team: " + playerteam));
        jp3.add(new JLabel("Role/s: " + playerrole));
        jp3.add(new JLabel("Nationality: " + playernationality));
        //jp3.add(new JSeparator());

//   
//   jp3.add(new JLabel("A line for Gumby"));
//   jp3.add(new JLabel("A line for Gumby"));
//   jp3.add(new JLabel("A line for Gumby"));
//   jp3.add(new JLabel("A line for Gumby"));
//   jp3.add(new JLabel("A line for Gumby"));
//   jp3.add(new JLabel("A line for Gumby"));
        jp1.add(jp3);
 //  jp1.add(new JLabel(new ImageIcon(picURL)));

   // second line
//   jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));  // NEW
//   jp2.add(new JLabel(cricketerPic));
//   jp2.add(new JLabel("Another line for Gumby"));
//   jp2.add(new JLabel(new ImageIcon(picURL)));
        Cricketer jlwi = new Cricketer();

        // vector.addElement(jp2);
        vector.addElement(jp1);
        jlwi.setListData(vector);
        jlwi.setBorder(new LineBorder(Color.red));
        cricketer.add(jlwi);

        cricketer.validate();
        return cricketer;

    }

    public static ImageIcon ScaledImageIcon(String path, int width, int height, String description) {
        return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH), description);
    }

    public String getPlayerfname() {
        return playerfname;
    }

    public String getPlayerlname() {
        return playerlname;
    }

    public String getPlayerteam() {
        return playerteam;
    }

    public String getPlayerrole() {
        return playerrole;
    }

    public int getPlayerid() {
        return playerid;
    }

    public String getBats() {
        return bats;
    }

    public String getBowls() {
        return bowls;
    }

    public String getPlayernationality() {
        return playernationality;
    }

    public void setId(int id) throws SQLException, IOException {
        try {
            sql.Connect();
            this.id = id;
            try {
                PlayerBio();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                Logger.getLogger(Cricketer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Cricketer.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql.CloseConn();
    }

}
