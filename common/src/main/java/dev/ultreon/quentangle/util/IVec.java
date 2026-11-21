package dev.ultreon.quentangle.util;

public interface IVec {
    double quent$x();
    double quent$y();
    double quent$z();

    int quent$blockX();
    int quent$blockY();
    int quent$blockZ();

    default double quent$distanceSq(IVec pos) {
        return (this.quent$x() - pos.quent$x()) * (this.quent$x() - pos.quent$x()) + (this.quent$y() - pos.quent$y()) * (this.quent$y() - pos.quent$y()) + (this.quent$z() - pos.quent$z()) * (this.quent$z() - pos.quent$z());
    }

    default double quent$distance(IVec pos) {
        return Math.sqrt(quent$distanceSq(pos));
    }

    default double quent$lengthSq() {
        return this.quent$x() * this.quent$x() + this.quent$y() * this.quent$y() + this.quent$z() * this.quent$z();
    }

    default double quent$length() {
        return Math.sqrt(quent$lengthSq());
    }

    IVec quent$copy();

    default boolean quent$isZero() {
        return this.quent$x() == 0 && this.quent$y() == 0 && this.quent$z() == 0;
    }

    default boolean quent$isEqual(IVec pos) {
        return this.quent$x() == pos.quent$x() && this.quent$y() == pos.quent$y() && this.quent$z() == pos.quent$z();
    }

    default boolean quent$isNotEqual(IVec pos) {
        return !this.quent$isEqual(pos);
    }

    default boolean quent$isPositive() {
        return this.quent$x() > 0 && this.quent$y() > 0 && this.quent$z() > 0;
    }

    default boolean quent$isNegative() {
        return this.quent$x() < 0 && this.quent$y() < 0 && this.quent$z() < 0;
    }

    int quent$getChunkX();

    int quent$getChunkZ();
}
