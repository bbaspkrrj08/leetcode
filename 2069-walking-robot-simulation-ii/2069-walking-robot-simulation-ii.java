class Robot {
    private int x, y, dir;
    private int width, height;
    private boolean hasMoved;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private final String[] dirs = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.hasMoved = false;
    }

    public void step(int num) {
        if (num == 0) return;
        hasMoved = true;
        int perimeter = 2 * (width + height - 2);
        num %= perimeter;
        while (num > 0) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                dir = (dir + 1) % 4;
            } else {
                x = nx;
                y = ny;
                num--;
            }
        }
        if (x == 0 && y == 0) {
            dir = 3;
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (!hasMoved) return "East";
        return dirs[dir];
    }
}