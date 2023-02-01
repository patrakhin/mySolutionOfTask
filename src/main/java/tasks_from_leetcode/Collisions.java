package tasks_from_leetcode;

public class Collisions {
    public int getCountCollisions(String directions) {
        int collisionsCars = 0;
        boolean isCarsCollided = false;
        char [] decodingDirections = directions.toCharArray();
        for (int i = 0; i < decodingDirections.length - 1; i++) {
            if (decodingDirections[i] == 'R' && decodingDirections[i+1] == 'L') {
                collisionsCars = collisionsCars + 2;
                decodingDirections[i+1] = 'S';
                decodingDirections[i] = 'S';
                i = i - 2;
                isCarsCollided = true;
            }
            if (i < 0) {
                i = -1;
                isCarsCollided = false;
                continue;
            }
            if (decodingDirections[i] == 'S' && decodingDirections[i+1] == 'L' && !isCarsCollided) {
                collisionsCars++;
                decodingDirections[i+1] = 'S';
                isCarsCollided = true;
            }
            if (decodingDirections[i] == 'R' && decodingDirections[i+1] == 'S' && !isCarsCollided) {
                collisionsCars++;
                decodingDirections[i] = 'S';
                i = i - 2;
            }
            if (i < 0) {
                i = -1;
            }
            isCarsCollided = false;
        }
        return collisionsCars;
    }
}
