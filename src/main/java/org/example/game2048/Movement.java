package org.example.game2048;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Movement {
    //  x0  x1  x2   x3
    //  [2]  [2]  [ ]  [2] y0
    //  [ ]  [4]  [4]  [ ] y1
    //  [ ]  [2]  [ ]  [ ] y2
    //  [2]  [ ]  [3]  [ ] y3

    public static List<Point> moveUp (List<Point> pointList) {
        IntStream.range(0, 4).forEach(i -> {
            List<Point> verticalLine = pointList.stream()
                    .filter(point -> point.getX() == i)
                    .sorted(Comparator.comparingInt(Point::getY))
                    .collect(Collectors.toList());
            if (verticalLine.size() == 1) {
                if (verticalLine.get(0).getY() != 0) {
                    verticalLine.get(0).setY(0);
                }
            } else if (verticalLine.size() == 2) {
                if (verticalLine.get(0).getValue().equals(verticalLine.get(1).getValue())) {
                    pointList.add(new Point(0, i, verticalLine.get(0).getValue() + verticalLine.get(1).getValue()));
                    pointList.remove(verticalLine.get(0));
                    pointList.remove(verticalLine.get(1));
                } else {
                    verticalLine.get(0).setY(0);
                    verticalLine.get(1).setY(1);
                }
            } else if (verticalLine.size() == 3) {
                IntStream.range(0, 3).forEach(j -> verticalLine.get(j).setY(j));
                if (verticalLine.get(0).getValue().equals(verticalLine.get(1).getValue())) {
                    verticalLine.get(0).setValue(verticalLine.get(0).getValue() + verticalLine.get(1).getValue());
                    verticalLine.get(1).setValue(verticalLine.get(2).getValue());
                    pointList.remove(verticalLine.get(2));
                } else if (verticalLine.get(1).getValue().equals(verticalLine.get(2).getValue())) {
                    verticalLine.get(1).setValue(verticalLine.get(1).getValue() + verticalLine.get(2).getValue());
                    pointList.remove(verticalLine.get(2));
                }
            } else if (verticalLine.size() == 4) {
                IntStream.range(0, 4).forEach(j -> verticalLine.get(j).setY(j));
                if (verticalLine.get(0).getValue().equals(verticalLine.get(1).getValue())) {
                    verticalLine.get(0).setValue(verticalLine.get(0).getValue() + verticalLine.get(1).getValue());
                    verticalLine.get(1).setValue(verticalLine.get(2).getValue());
                    verticalLine.get(2).setValue(verticalLine.get(3).getValue());
                    pointList.remove(verticalLine.get(3));
                    verticalLine.remove(3);

                } else {
                    if (verticalLine.get(1).getValue().equals(verticalLine.get(2).getValue())){
                        verticalLine.get(1).setValue(verticalLine.get(1).getValue() + verticalLine.get(2).getValue());
                        verticalLine.get(2).setValue(verticalLine.get(3).getValue());
                        pointList.remove(verticalLine.get(3));
                        verticalLine.remove(3);
                    }
                } if (verticalLine.get(2).getValue().equals(verticalLine.get(3).getValue())){
                    verticalLine.get(1).setValue(verticalLine.get(0).getValue() + (verticalLine.get(1).getValue()));
                    pointList.remove(verticalLine.get(0));
                }
            }
            verticalLine.clear();
        });
        return pointList;
    }

    public static List<Point> moveDown (List<Point> pointList) {
        IntStream.range(0, 4).forEach(i -> {
            List<Point> verticalLine = pointList.stream()
                    .filter(point -> point.getX() == i)
                    .sorted(Comparator.comparingInt(Point::getY))
                    .collect(Collectors.toList());
            if (verticalLine.size() == 1) {
                if (verticalLine.get(0).getY() != 3) {
                    verticalLine.get(0).setY(3);
                }
            } else if (verticalLine.size() == 2) {
                if (verticalLine.get(0).getValue().equals(verticalLine.get(1).getValue())) {
                    pointList.add(new Point(i, 3, verticalLine.get(0).getValue() + verticalLine.get(1).getValue()));
                    pointList.remove(verticalLine.get(0));
                    pointList.remove(verticalLine.get(1));
                } else {
                    verticalLine.get(0).setY(2);
                    verticalLine.get(1).setY(3);
                }
            } else if (verticalLine.size() == 3) {
                int tmp = 1;
                for (Point point : verticalLine) {
                    point.setY(tmp);
                    tmp = tmp +1;
                }
                if (verticalLine.get(0).getValue().equals(verticalLine.get(1).getValue())) {
                    verticalLine.get(0).setValue(verticalLine.get(0).getValue() + verticalLine.get(1).getValue());
                    verticalLine.get(1).setValue(verticalLine.get(2).getValue());
                    pointList.remove(verticalLine.get(2));
                } else if (verticalLine.get(1).getValue().equals(verticalLine.get(2).getValue())) {
                    verticalLine.get(1).setValue(verticalLine.get(1).getValue() + verticalLine.get(2).getValue());
                    pointList.remove(verticalLine.get(2));
                }
            } else if (verticalLine.size() == 4) {

                IntStream.range(0, 4).forEach(j -> verticalLine.get(j).setY(j));
                if (verticalLine.get(2).getValue().equals(verticalLine.get(3).getValue())){
                    verticalLine.get(3).setValue(verticalLine.get(2).getValue() + verticalLine.get(3).getValue());
                    verticalLine.get(2).setValue(verticalLine.get(1).getValue());
                    verticalLine.get(1).setValue(verticalLine.get(0).getValue());
                    pointList.remove(verticalLine.get(0));
                    verticalLine.remove(0);

                } else {
                    if (verticalLine.get(1).getValue().equals(verticalLine.get(2).getValue())){
                        verticalLine.get(2).setValue(verticalLine.get(1).getValue() + verticalLine.get(2).getValue());
                        verticalLine.get(1).setValue(verticalLine.get(0).getValue());
                        pointList.remove(verticalLine.get(0));
                        verticalLine.remove(0);
                    }
                } if (verticalLine.get(0).getValue().equals(verticalLine.get(1).getValue())){
                    verticalLine.get(1).setValue(verticalLine.get(0).getValue() + (verticalLine.get(1).getValue()));
                    pointList.remove(verticalLine.get(0));
                }
            }
            verticalLine.clear();
        });
        return pointList;
    }

    public static List<Point> moveLeft (List<Point> pointList) {
        int firstPosition = 0, secondPosition = 1, thirdPosition = 2, fourthPosition = 3;
        IntStream.range(0, 4).forEach(i -> {
            List<Point> horizontalLine = pointList.stream()
                    .filter(point -> point.getY() == i)
                    .sorted(Comparator.comparingInt(Point::getX))
                    .collect(Collectors.toList());
            if (horizontalLine.size() == 1) {
                if (horizontalLine.get(0).getX() != firstPosition) {
                    horizontalLine.get(0).setX(firstPosition);
                }
            } else if (horizontalLine.size() == 2) {
                if (horizontalLine.get(0).getValue().equals(horizontalLine.get(1).getValue())) {
                    pointList.add(new Point(firstPosition, i, horizontalLine.get(0).getValue() + horizontalLine.get(1).getValue()));
                    pointList.remove(horizontalLine.get(0));
                    pointList.remove(horizontalLine.get(1));
                } else {
                    horizontalLine.get(0).setX(firstPosition);
                    horizontalLine.get(1).setX(secondPosition);
                }
            } else if (horizontalLine.size() == 3) {
                IntStream.range(firstPosition, fourthPosition).forEach(j -> horizontalLine.get(j).setX(j));
                if (horizontalLine.get(firstPosition).getValue().equals(horizontalLine.get(secondPosition).getValue())) {

                    horizontalLine.get(firstPosition).setValue(horizontalLine.get(firstPosition).getValue() + horizontalLine.get(secondPosition).getValue());
                    horizontalLine.get(secondPosition).setValue(horizontalLine.get(thirdPosition).getValue());
                    pointList.remove(horizontalLine.get(2));
                } else if (horizontalLine.get(secondPosition).getValue().equals(horizontalLine.get(thirdPosition).getValue())) {
                    horizontalLine.get(secondPosition).setValue(horizontalLine.get(secondPosition).getValue() + horizontalLine.get(thirdPosition).getValue());
                    pointList.remove(horizontalLine.get(2));
                }
            } else if (horizontalLine.size() == 4) {
                IntStream.range(0, 4).forEach(j -> horizontalLine.get(j).setX(j));
                if (horizontalLine.get(0).getValue().equals(horizontalLine.get(1).getValue())) {
                    horizontalLine.get(0).setValue(horizontalLine.get(0).getValue() + horizontalLine.get(1).getValue());
                    horizontalLine.get(1).setValue(horizontalLine.get(2).getValue());
                    horizontalLine.get(2).setValue(horizontalLine.get(3).getValue());
                    pointList.remove(horizontalLine.get(3));
                    horizontalLine.remove(3);

                } else {
                    if (horizontalLine.get(1).getValue().equals(horizontalLine.get(2).getValue())){
                        horizontalLine.get(1).setValue(horizontalLine.get(1).getValue() + horizontalLine.get(2).getValue());
                        horizontalLine.get(2).setValue(horizontalLine.get(3).getValue());
                        pointList.remove(horizontalLine.get(3));
                        horizontalLine.remove(3);
                    }
                } if (horizontalLine.get(2).getValue().equals(horizontalLine.get(3).getValue())) {
                    horizontalLine.get(1).setValue(horizontalLine.get(0).getValue() + (horizontalLine.get(1).getValue()));
                    pointList.remove(horizontalLine.get(0));
                }
            }
            horizontalLine.clear();
        });

        return pointList;
    }

    public static List<Point> moveRight(List<Point> pointList) {
        int firstPosition = 3, secondPosition = 2, thirdPosition = 1, fourthPosition = 0;
        IntStream.range(0, 4).forEach(i -> {
            List<Point> horizontalLine = pointList.stream()
                    .filter(point -> point.getY() == i)
                    .sorted(Comparator.comparingInt(Point::getX))
                    .collect(Collectors.toList());

            if (horizontalLine.size() == 1) {
                if (horizontalLine.get(0).getX() != firstPosition) {
                    horizontalLine.get(0).setX(firstPosition);
                }
            } else if (horizontalLine.size() == 2) {
                if (horizontalLine.get(0).getValue().equals(horizontalLine.get(1).getValue())) {
                    pointList.add(new Point(firstPosition, i, horizontalLine.get(0).getValue() + horizontalLine.get(1).getValue()));
                    pointList.remove(horizontalLine.get(0));
                    pointList.remove(horizontalLine.get(1));
                } else {
                    horizontalLine.get(0).setX(secondPosition);
                    horizontalLine.get(1).setX(firstPosition);
                }
            } else if (horizontalLine.size() == 3) {
                IntStream.range(0, 3).forEach(j -> horizontalLine.get(j).setX(j+1));
                if (horizontalLine.get(1).getValue().equals(horizontalLine.get(2).getValue())) {
                    horizontalLine.get(2).setValue(horizontalLine.get(1).getValue() + horizontalLine.get(2).getValue());
                    horizontalLine.get(1).setValue(horizontalLine.get(0).getValue());
                    pointList.remove(horizontalLine.get(0));
                } else if (horizontalLine.get(0).getValue().equals(horizontalLine.get(1).getValue())) {
                    horizontalLine.get(1).setValue(horizontalLine.get(0).getValue() + horizontalLine.get(1).getValue());
                    pointList.remove(horizontalLine.get(0));
                }
            } else if (horizontalLine.size() == 4) {

                IntStream.range(0, 4).forEach(j -> horizontalLine.get(j).setX(j));
                if (horizontalLine.get(2).getValue().equals(horizontalLine.get(3).getValue())) {
                    horizontalLine.get(3).setValue(horizontalLine.get(2).getValue() + horizontalLine.get(3).getValue());
                    horizontalLine.get(2).setValue(horizontalLine.get(1).getValue());
                    horizontalLine.get(1).setValue(horizontalLine.get(0).getValue());
                    pointList.remove(horizontalLine.get(0));
                    horizontalLine.remove(0);

                } else {
                    if (horizontalLine.get(1).getValue().equals(horizontalLine.get(2).getValue())){
                        horizontalLine.get(2).setValue(horizontalLine.get(1).getValue() + horizontalLine.get(2).getValue());
                        horizontalLine.get(1).setValue(horizontalLine.get(0).getValue());
                        pointList.remove(horizontalLine.get(0));
                        horizontalLine.remove(0);
                    }
                } if (horizontalLine.get(0).getValue().equals(horizontalLine.get(1).getValue())) {
                    horizontalLine.get(1).setValue(horizontalLine.get(0).getValue() + (horizontalLine.get(1).getValue()));
                    pointList.remove(horizontalLine.get(0));
                }
            }
            horizontalLine.clear();
        });
        return pointList;
        }

}