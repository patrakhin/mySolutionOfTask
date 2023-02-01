package tasks_from_leetcode;

import java.util.*;

public class CarFleet {
    static class Car {
        int position;
        int speed;
        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }

    public int getCarFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        // sort cars in ascending order by position
        Arrays.sort(cars, (a, b) -> a.position - b.position);

        Stack<Double> fleets = new Stack<>();
        for (int i = cars.length - 1; i >= 0; i--) {
            // calculate how many seconds before this car reaches the target
            double time = (double) (target - cars[i].position) / cars[i].speed;
            // check if this car will get stuck behind a car that was ahead
            if (!fleets.isEmpty() && time <= fleets.peek()) {
                // keep the slower car ahead's time on the top of the stack
                // because it will block any faster cars from behind
                continue;
            }
            fleets.push(time);
        }
        return fleets.size();
    }
}
