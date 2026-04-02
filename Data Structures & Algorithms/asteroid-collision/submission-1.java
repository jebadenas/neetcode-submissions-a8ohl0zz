class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> asteroidStack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++){
            if (asteroids[i] > 0){
                asteroidStack.push(asteroids[i]);
            }else{
                boolean destroyed = false;
                while (!asteroidStack.isEmpty() && asteroidStack.peek() > 0 && !destroyed){
                    int poppedAsteroid = asteroidStack.pop();
                    
                    if (poppedAsteroid + asteroids[i] > 0){
                        destroyed = true;
                        asteroidStack.push(poppedAsteroid);
                    }else if (poppedAsteroid + asteroids[i] == 0){
                        destroyed = true;
                    }
                }
                if (!destroyed && (asteroidStack.isEmpty() || asteroidStack.peek() < 0)){
                    asteroidStack.push(asteroids[i]);
                }
            }
        }

        int[] res = new int[asteroidStack.size()];

        for (int i = 0 ;i < asteroidStack.size(); i++){
            res[i] = asteroidStack.get(i);
        }


        return res;

    }
}