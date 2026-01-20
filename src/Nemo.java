import java.awt.*;

public class Nemo {
    String name;
    Image aliveImage;
    Image deadImage;
    int xpos;
    int ypos;
    double dx;
    double dy;
    int width;
    int height;
    Rectangle hitbox;
    boolean isAlive = true;
    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;

    public Nemo(){
        hitbox = new Rectangle(xpos,ypos,width,height);
        // convention for making a rectangle
    }

    public Nemo(int xposInput, int yposInput, double dxInput,
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
        //  xpos = xpos + (int) dx;
        // ypos = ypos + (int) dy;

        if (up){
            ypos = ypos - (int)dy;
        }
        if (down){
            ypos = ypos + (int)dy;
        }
        if (right){
            xpos = xpos + (int)dx;
        }
        if (left){
            xpos = xpos - (int)dx;
        }

        if (xpos >= 1000){dx = dx * -1;}
        if (xpos <= 0){dx = dx * -1;}
        if (ypos >= 700) {dy = dy * -1;}
        if (ypos <= 0){dy = dy * -1;}

        hitbox = new Rectangle(xpos,ypos,width,height);

        if (xpos == 0) {
            dx = -dx;
            xpos = 0;
        }
        if (ypos == 0) {
            dy = -dy;
            ypos = 0;
        }

    }

    public static void main(String[] args) {

    }


}
