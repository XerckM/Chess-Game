package com.xmdev.chess.common;

import java.util.Objects;

public class Location {
    private final File file;
    private final Integer rank;

    public Location(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    public File getFile() {
        return file;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (!(obj instanceof Location)) { return false; }
        Location location = (Location) obj;
        return file == location.file && rank == location.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    @Override
    public String toString() {
        return "Location{" +
                "file=" + file +
                ", rank=" + rank +
                '}';
    }
}
