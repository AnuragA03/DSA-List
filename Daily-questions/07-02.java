//! 3160. Find the Number of Distinct Colors Among the Balls

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        // Map to store which color is assigned to each ball
        Map<Integer, Integer> ballColorMap = new HashMap<>();

        // Map to store the count of each color
        Map<Integer, Integer> colorCountMap = new HashMap<>();

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            // If the ball already has a color, remove its contribution from the count
            if (ballColorMap.containsKey(ball)) {
                int oldColor = ballColorMap.get(ball);
                colorCountMap.put(oldColor, colorCountMap.get(oldColor) - 1);

                // If a color count drops to 0, remove it from the map
                if (colorCountMap.get(oldColor) == 0) {
                    colorCountMap.remove(oldColor);
                }
            }

            // Assign the new color to the ball
            ballColorMap.put(ball, color);

            // Update the count of the new color
            colorCountMap.put(color, colorCountMap.getOrDefault(color, 0) + 1);

            // The number of distinct colors is the size of colorCountMap
            result[i] = colorCountMap.size();
        }

        return result;
    }
}