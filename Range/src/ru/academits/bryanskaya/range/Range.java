package ru.academits.bryanskaya.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double numberToCheck) {
        return numberToCheck >= from && numberToCheck <= to;
    }

    public String toString() {
        return "[" + from + ";" + to + "]";
    }

    public Range getIntersection(Range otherRange) {
        double intersectionFrom = Math.max(from, otherRange.from);
        double intersectionTo = Math.min(to, otherRange.to);

        if (intersectionFrom < intersectionTo) {
            return new Range(intersectionFrom, intersectionTo);
        }

        return null;
    }

    public Range[] getUnion(Range otherRange) {
        if (from <= otherRange.to && otherRange.from <= to) {
            double unionFrom = Math.min(otherRange.from, from);
            double unionTo = Math.max(otherRange.to, to);

            return new Range[]{new Range(unionFrom, unionTo)};
        }

        if (from < otherRange.from) {
            return new Range[]{
                    new Range(from, to),
                    new Range(otherRange.from, otherRange.to)
            };
        } else {
            return new Range[]{
                    new Range(otherRange.from, otherRange.to),
                    new Range(from, to)
            };
        }
    }

    public Range[] getDifference(Range otherRange) {
        // Если отрезки не пересекаются, возвращается первый диапазон
        if (otherRange.from > to || otherRange.to < from) {
            return new Range[]{new Range(from, to)};
        }
        // Если второй диапазон полностью находится в пределах первого, возвращается разность из двух диапазонов
        if (otherRange.from > from && otherRange.to < to) {
            return new Range[]{
                    new Range(from, otherRange.from),
                    new Range(otherRange.to, to)
            };
        }
        // Если начало второго диапазона в пределах первого, возвращается разность диапазонов слева
        if (otherRange.from > from && otherRange.from <= to) {
            return new Range[]{new Range(from, otherRange.from)};
        }
        // Если конец второго диапазона в пределах первого, возвращается разность диапазонов справа
        if (otherRange.to < to && otherRange.to >= from) {
            return new Range[]{new Range(otherRange.to, to)};
        }
        // Если второй диапазон полностью перекрывает первый, возвращается пустой массив
        return new Range[0];
    }
}
