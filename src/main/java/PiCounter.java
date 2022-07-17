import java.util.Random;

public class PiCounter {

    public static void main(String[] args) {


        long  timeStart = System.currentTimeMillis();

        //unit circle
        //center = (0,0) x1 = 0, y1 = 0
        //radius = 1

        final int RADIUS = 1;

        long numberOfTries = 10000000000L;
        long locatedInQuarterCircle = 0;

        Random random = new Random();

        for(long i = 0; i < numberOfTries; i++ ){
            //nextDouble() returns number from 0 to 1;
            double x = random.nextDouble();
            double y = random.nextDouble();

            // to count distance between x1,y1 and x2,y2 we need root of ((x2-x1)^2 + (y2 -y1)^2)
            // in our case x1 = 0 and y1 = 0, so we can make simpler that math formula to root of (x^2 + y^2)
            //exactly what returns Math.hypot
            double distance = Math.hypot(x,y);

            //to decide if a point is located in our quarter of circle we need to check if distance is less or equal radius;
            if(distance <= RADIUS){
                locatedInQuarterCircle++;
            }

        }

        //the ratio of the circle area to area of square described on that circle
        //roughly equals number of points in that circle to number of all points in that square
        //same for quarter of that circle to quarter of that square

        double ratio = locatedInQuarterCircle/(double)numberOfTries;

        //PI = 4 * (area of circle/are of square described on that square)
        double PI = 4 * ratio;

        long elapsedTime = System.currentTimeMillis() - timeStart;

        System.out.println("PI = " + PI);
        System.out.println(elapsedTime + "millis");
    }
}
