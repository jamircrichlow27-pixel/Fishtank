import java.awt.*;

public class Dory {
    String name;
    Image image;
    int xpos;
    int ypos;
    double dx;
    double dy;
    int width;
    int height;
    Rectangle hitbox;

    public Dory(){
        hitbox = new Rectangle(xpos,ypos,width,height);
        // convention for making a rectangle
    }

    public Dory(int xposInput, int yposInput, double dxInput,
                         double dyInput, int widthInput, int heightInput){
        xpos = xposInput;
        ypos = yposInput;
        dx = dxInput;
        dy = dyInput;
        width = widthInput;
        height = heightInput;

        hitbox = new Rectangle(xpos,ypos,width,height);
    }

    public void move(){
        xpos = xpos + (int) dx;
        ypos = ypos + (int) dy;

        if (xpos >= 1000){
            dx = dx * -1;
        }
        if (xpos <= 0){
            dx = dx * -1;
        }
        if (ypos >= 700) {
            dy = dy * -1;
        }
        if (ypos <= 0){
            dy = dy * -1;
        }
        if (xpos == 700){
            dx = -dx;
            //xpos = 0;
        }


    }

    public static void main(String[] args) {

    }


}
