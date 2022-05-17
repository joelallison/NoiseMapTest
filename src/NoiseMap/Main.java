package NoiseMap;

import tools.OpenSimplex2S;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        Character[][] grid = Grid();

        for (Character[] x:grid) {
            for (Character c:x) {
                System.out.print(c + " ");
            }System.out.println();
        }
    }

    public static Character[][] Grid () {
        OpenSimplex2S noise = new OpenSimplex2S();
        final int dimension = 128;
        Character[][] grid = new Character[dimension][dimension];
        long seed = 865234L;

        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {
                float value = (float) abs(noise.noise2(seed, x, y));

                System.out.println(value);

                if (value <= 0.25f) {
                    grid[x][y] = ' ';
                } else if (value <= 0.5f) {
                    grid[x][y] = '▒';
                } else if (value <= 0.75f) {
                    grid[x][y] = '▓';
                } else if (value <= 1.0f) {
                    grid[x][y] = '█';
                }
            }
        }

        return grid;
    }

    public static float roundToQuarter(float f) {
        return Math.round(f * 4) / 4.0f;
    }
}
