package com.mygdx.game.Units;

public class Position {
    public int x, y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setX(int curX){
        this.x = curX;
    }
    public void setY(int curY){
        this.y = curY;
    }
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
//    }
//    public static void setWidth(int width){
//        Position.width = width;
//    }
//    public static void setHeight(int height){
//        Position.height = height;
//    }
//    public static int getWidth(){
//        return width;
//    }
//    public static int getHeight(){
//        return height;
//    }
//    public List<Integer> getPosition(){
//        List<Integer> list = new ArrayList<>();
//        list.add(x);
//        list.add(y);
//        return list;
//    }
    }

    public float fastDistance(Position other, int dx, int dy) {
        int dx1 = other.getX() - x;
        int dy1 = other.getY() - y;
        return dx1 * dx + dy1 * dy;

    }

    public Position getDelta(Position other) {
        return new Position(other.getX() - getX(), other.getY() - getY());
    }

    public float distanceTo(Position target) {
        float x = this.x - target.getY();
        float y = this.y - target.getX();
        return (float) Math.sqrt(x*x + y*y);
    }

    public void add(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public boolean check(Position pt) {
        return this.x == pt.getX() && this.y == pt.getY();
    }
    public String toString(){return x + ":" + y;}
}
