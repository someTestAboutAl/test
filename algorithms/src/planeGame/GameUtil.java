package planeGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * description
 * Author: HP
 * Date: 2022/3/30
 * Time: 22:10
 */
public class GameUtil {
    private GameUtil(){

    }

    public static Image getImage(String path){
        BufferedImage bi = null;
        try {
            URL u = GameUtil.class.getClassLoader().getResource(path);
            bi = ImageIO.read(u);
        }catch (IOException e){
            e.printStackTrace();
        }
        return bi;
    }
}
