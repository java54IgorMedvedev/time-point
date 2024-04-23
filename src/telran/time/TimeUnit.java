package telran.time;

public enum TimeUnit {
HOUR(3600), MINUTE(60), SECOND(1);
	int value;
	private TimeUnit(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public TimePoint between(TimePoint point1, TimePoint point2) {
	    int seconds1 = point1.getAmount() * point1.getTimeUnit().value;
	    int seconds2 = point2.getAmount() * point2.getTimeUnit().value;
	    int differenceInSeconds = Math.abs(seconds2 - seconds1);
	    return new TimePoint(differenceInSeconds / this.value, this);
	}

}