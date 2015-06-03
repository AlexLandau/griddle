package net.alloyggp.griddle;

public class GdlProblem {
	private final Level level;
	private final Position position;
	private final String message;

	public static enum Level {
		WARNING,
		ERROR
	}

	private GdlProblem(Level level, Position position, String message) {
		this.level = level;
		this.position = position;
		this.message = message;
	}
}
