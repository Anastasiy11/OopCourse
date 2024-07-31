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
        return "[" + from + "; " + to + "]";
    }

    public Range getIntersection(Range range) {
        double intersectionFrom = Math.max(from, range.from);
        double intersectionTo = Math.min(to, range.to);

        if (intersectionFrom < intersectionTo) {
            return new Range(intersectionFrom, intersectionTo);
        }

        return null;
    }

    public Range[] getUnion(Range range) {
        if (from <= range.to && range.from <= to) {
            double unionFrom = Math.min(range.from, from);
            double unionTo = Math.max(range.to, to);

            return new Range[]{new Range(unionFrom, unionTo)};
        }

        if (from < range.from) {
            return new Range[]{
                    new Range(from, to),
                    new Range(range.from, range.to)
            };
        }

        return new Range[]{
                new Range(range.from, range.to),
                new Range(from, to)
        };
    }

    public Range[] getDifference(Range range) {
        // Если отрезки не пересекаются, возвращается первый диапазон
        if (range.from > to || range.to < from) {
            return new Range[]{new Range(from, to)};
        }

        // Если второй диапазон полностью находится в пределах первого, возвращается разность из двух диапазонов
        if (range.from > from && range.to < to) {
            return new Range[]{
                    new Range(from, range.from),
                    new Range(range.to, to)
            };
        }

        // Если начало второго диапазона в пределах первого, возвращается разность диапазонов слева
        if (range.from > from && range.from <= to) {
            return new Range[]{new Range(from, range.from)};
        }

        // Если конец второго диапазона в пределах первого, возвращается разность диапазонов справа
        if (range.to < to && range.to >= from) {
            return new Range[]{new Range(range.to, to)};
        }

        // Если второй диапазон полностью перекрывает первый, возвращается пустой массив
        return new Range[0];
    }
}
