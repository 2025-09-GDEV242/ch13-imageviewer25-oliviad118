import java.awt.Color;

/**
 * A filter to apply a green tint to an image.
 * Enhances the green component while maintaining the other colors.
 * 
 * @author Student
 * @version 1.0
 */
public class GreenTintFilter extends Filter
{
    /**
     * Constructor for objects of class GreenTintFilter.
     * @param name The name of the filter.
     */
    public GreenTintFilter(String name)
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
                int green = Math.min(255, (int)(pix.getGreen() * 1.5));
                int blue = (int)(pix.getBlue() * 0.8);
                image.setPixel(x, y, new Color(red, green, blue));
            }
        }
    }
}