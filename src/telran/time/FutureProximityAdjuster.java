package telran.time;

public class FutureProximityAdjuster implements TimePointAdjuster{
TimePoint[] timePoints;
public FutureProximityAdjuster(TimePoint[] points) {
    this.timePoints = points;
}

public TimePoint adjust(TimePoint point) {
    TimePoint nearestFuture = null;
    int smallestDifference = Integer.MAX_VALUE;

    for (TimePoint testPoint : timePoints) {
        int comparison = testPoint.compareTo(point);
        if (comparison > 0) {  
            int difference = Math.abs(comparison);
            if (difference < smallestDifference) {
                smallestDifference = difference;
                nearestFuture = testPoint;
            }
        }
    }
    return nearestFuture;
}
}