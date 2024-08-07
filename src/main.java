package Steam_N1;

import java.awt.*;

import javax.swing.*;


public class main {


    public static void main(String[] args) {


        locate window = new locate();

        window.setVisible(true);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //window.setResizable(false); Por si queremos que se expanda la pestaña

        //window.setExtendedState(JFrame.MAXIMIZED_BOTH); Por si queremos pestaña completa al iniciar

    }

}


class locate extends JFrame {

    public locate() {

        Toolkit screen = Toolkit.getDefaultToolkit();

        Dimension size = screen.getScreenSize();


        int height = size.height;

        int width = size.width;

        setSize(width/2, height/2);

        setLocation(width/4, height/4);

        setTitle("P2W");

        Image icon = screen.getImage("https://fbi.cults3d.com/uploaders/15076709/illustration-file/e478385b-e4f9-4abd-b79f-629cae2a3b7d/1.jpg");

        setIconImage(icon);
    }

    
}
