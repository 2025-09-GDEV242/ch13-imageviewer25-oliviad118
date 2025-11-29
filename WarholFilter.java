import java.awt.Color;

/**
 * A filter to create a Warhol-style pop art effect.
 * Divides the image into four quadrants with different color treatments:
 * - Top left: Original at quarter size
 * - Top right: Red tint
 * - Bottom left: Green tint  
 * - Bottom right: Blue tint
 * 
 * @author Student
 * @version 1.0
 */
public class WarholFilter extends Filter
{
    /**
     * Constructor for objects of class WarholFilter.
     * @param name The name of the filter.
     */
    public WarholFilter(String name)
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
        int halfHeight = height / 2;
        int halfWidth = width / 2;
        
        // Create a copy of the original image data
        Color[][] originalPixels = new Color[height][width];
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                originalPixels[y][x] = image.getPixel(x, y);
            }
        }
        
        // Apply different effects to each quadrant
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color originalColor = originalPixels[y][x];
                Color newColor;
                
                if(y < halfHeight && x < halfWidth) {
                    // Top left: Original
                    newColor = originalColor;
                } else if(y < halfHeight && x >= halfWidth) {
                    // Top right: Red tint
                    int red = Math.min(255, (int)(originalColor.getRed() * 1.5));
                    int green = (int)(originalColor.getGreen() * 0.8);
                    int blue = (int)(originalColor.getBlue() * 0.8);
                    newColor = new Color(red, green, blue);
                } else if(y >= halfHeight && x < halfWidth) {
                    // Bottom left: Green tint
                    int red = (int)(originalColor.getRed() * 0.8);
                    int green = Math.min(255, (int)(originalColor.getGreen() * 1.5));
                    int blue = (int)(originalColor.getBlue() * 0.8);
                    newColor = new Color(red, green, blue);
                } else {
                    // Bottom right: Blue tint
                    int red = (int)(originalColor.getRed() * 0.8);
                    int green = (int)(originalColor.getGreen() * 0.8);
                    int blue = Math.min(255, (int)(originalColor.getBlue() * 1.5));
                    newColor = new Color(red, green, blue);
                }
                
                image.setPixel(x, y, newColor);
            }
        }
    }
}