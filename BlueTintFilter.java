import java.awt.Color;

/**
 * A filter to apply a blue tint to an image.
 * Enhances the blue component while maintaining the other colors.
 * 
 * @author Student
 * @version 1.0
 */
public class BlueTintFilter extends Filter
{
    /**
     * Constructor for objects of class BlueTintFilter.
     * @param name The name of the filter.
     */
    public BlueTintFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int red = (int)(pix.getRed() * 0.8);
                int green = (int)(pix.getGreen() * 0.8);
                int blue = Math.min(255, (int)(pix.getBlue() * 1.5));
                image.setPixel(x, y, new Color(red, green, blue));
            }
        }
    }
}