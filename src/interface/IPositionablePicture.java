import java.awt.image.BufferedImage;

public interface IPositionablePicture {
    /**
     * will retrun a image in the style of BufferedImage type
     * @return
     */
    BufferedImage getImage();

    /**
     * Just simply returns the position from i posianable
     * @return
     */

    Position getPosition() ;

}
