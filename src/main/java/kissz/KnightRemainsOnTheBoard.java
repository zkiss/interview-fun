package kissz;

import java.util.*;

public class KnightRemainsOnTheBoard {
    int[] moveX = {1, 2,  2,  1, -1, -2, -2, -1};
    int[] moveY = {2, 1, -1, -2,  2,  1, -1, -2};

    static class PositionProbability {
        final double p;
        final int x, y;

        PositionProbability(double p, int x, int y) {
            this.p = p;
            this.x = x;
            this.y = y;
        }

        public boolean onBoard(int N) {
            return x >= 0 && x < N && y >= 0 && y < N;
        }

        public PositionProbability add(PositionProbability other) {
            return new PositionProbability(p + other.p, x, y);
        }

        @Override
        public boolean equals(Object obj) {
            PositionProbability other = (PositionProbability)obj;
            return other.x == x && other.y == y;
        }

        @Override
        public int hashCode() {
            return x << 16 + y;
        }
    }
    public double knightProbability(int N, int K, int r, int c) {
        int offBoard = 0;
        HashMap<PositionProbability, PositionProbability> positions;
        HashMap<PositionProbability, PositionProbability> prevPositions = new HashMap<>();
        PositionProbability first = new PositionProbability(1.d, r, c);
        prevPositions.put(first, first);
        for (int move = 0; move < K; move++) {
            positions = new HashMap<>(prevPositions.size() * 8);
            for (PositionProbability prevPosition : prevPositions.values()) {
                for (int i = 0; i < 8; i++) {
                    PositionProbability position = new PositionProbability(prevPosition.p / 8,
                            prevPosition.x + moveX[i],
                            prevPosition.y + moveY[i]);
                    if (position.onBoard(N)) {
                        if (positions.containsKey(position)) {
                            position = positions.get(position).add(position);
                        }
                        positions.put(position, position);
                    }
                }
            }

            prevPositions = positions;
        }

        return prevPositions.values().stream().mapToDouble(pos -> pos.p).sum();
    }
}
