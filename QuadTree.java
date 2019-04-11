package quad;
public class QuadTree {
    QuadTree northeast;
    QuadTree northwest;
    QuadTree southeast;
    QuadTree southwest;
    
    public int xx;
    public int yy;
    private int size;
    private int numChildren;
    public QuadTree(int x, int y) {
        xx = x;
        yy = y;
        size = 1;
    }
    public void add(int x, int y) {
        if (x >= xx) {
            if (y >= y) {
                if (northeast == null) {
                    northeast = new QuadTree(x, y);
                    size++;
                } else {
                    northeast.add(x, y);
                    size = 1 + size(southeast) + size(northeast) + size(southwest) + size(northwest);
                }
            } else {
                if (southeast == null) {
                    southeast = new QuadTree(x, y);
                    size++;
                } else {
                    southeast.add(x, y);
                    size = 1 + size(southeast) + size(northeast) + size(southwest) + size(northwest);
                }
            }
        } else {
           if (y >= y) {
                if (northwest == null) {
                    northwest = new QuadTree(x, y);
                    size++;
                } else {
                    northwest.add(x, y);
                    size = 1 + size(southeast) + size(northeast) + size(southwest) + size(northwest);
                }
            } else {
                if (southwest == null) {
                    southwest = new QuadTree(x, y);
                    size++;
                } else {
                    southwest.add(x, y);
                    size = 1 + size(southeast) + size(northeast) + size(southwest) + size(northwest);
                }
            }
        }

    }
    public void contains(int x, int y) {
    }
    public void delete(int x, int y) {
    }
    public int size() {
        return size;
    }
    private static int size(QuadTree q) {
        if (q == null) {
            return 0;
        }
        return q.size();
    }
    public static void main(String[] args) {
        QuadTree q = new QuadTree(1, 1);
        q.add(2, 3);
        q.add(3, 4);
        System.out.println(q.size());
        System.out.println(q.northeast.size());

    }
}
