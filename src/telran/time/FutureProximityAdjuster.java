package telran.time;

public class FutureProximityAdjuster implements TimePointAdjuster{
TimePoint[] timePoints;
public FutureProximityAdjuster(TimePoint[] points) {
    this.timePoints = points;
}

@Override
public TimePoint adjust(TimePoint point) {
    TimePoint closest = null;
    int smallestDifference = Integer.MAX_VALUE;
    for (TimePoint testPoint : timePoints) {
        int difference = Math.abs(point.compareTo(testPoint));
        if (difference < smallestDifference) {
            smallestDifference = difference;
            closest = testPoint;
        }
    }
    return closest;
}
}