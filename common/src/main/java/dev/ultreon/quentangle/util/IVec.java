package dev.ultreon.quentangle.util;

public interface IVec {
    double getX();
    double getY();
    double getZ();

    void setX(double x);
    void setY(double y);
    void setZ(double z);

    int getBlockX();
    int getBlockY();
    int getBlockZ();

    default double distanceSq(IVec pos) {
        return (this.getX() - pos.getX()) * (this.getX() - pos.getX()) + (this.getY() - pos.getY()) * (this.getY() - pos.getY()) + (this.getZ() - pos.getZ()) * (this.getZ() - pos.getZ());
    }

    default double distance(IVec pos) {
        return Math.sqrt(distanceSq(pos));
    }

    default double lengthSq() {
        return this.getX() * this.getX() + this.getY() * this.getY() + this.getZ() * this.getZ();
    }

    default double length() {
        return Math.sqrt(lengthSq());
    }

    default Vec toVec() {
        return new Vec(this.getX(), this.getY(), this.getZ());
    }

    default IVec add(IVec pos) {
        this.setX(this.getX() + pos.getX());
        this.setY(this.getY() + pos.getY());
        this.setZ(this.getZ() + pos.getZ());
        return this;
    }

    default IVec sub(IVec pos) {
        this.setX(this.getX() - pos.getX());
        this.setY(this.getY() - pos.getY());
        this.setZ(this.getZ() - pos.getZ());
        return this;
    }

    default IVec mul(double scalar) {
        this.setX(this.getX() * scalar);
        this.setY(this.getY() * scalar);
        this.setZ(this.getZ() * scalar);
        return this;
    }

    default IVec mul(IVec pos) {
        this.setX(this.getX() * pos.getX());
        this.setY(this.getY() * pos.getY());
        this.setZ(this.getZ() * pos.getZ());
        return this;
    }

    default IVec div(double scalar) {
        this.setX(this.getX() / scalar);
        this.setY(this.getY() / scalar);
        this.setZ(this.getZ() / scalar);
        return this;
    }

    default IVec div(IVec pos) {
        this.setX(this.getX() / pos.getX());
        this.setY(this.getY() / pos.getY());
        this.setZ(this.getZ() / pos.getZ());
        return this;
    }

    default IVec negate() {
        this.setX(-this.getX());
        this.setY(-this.getY());
        this.setZ(-this.getZ());
        return this;
    }

    default IVec normalize() {
        double length = this.length();
        this.setX(this.getX() / length);
        this.setY(this.getY() / length);
        this.setZ(this.getZ() / length);
        return this;
    }

    IVec copy();

    default boolean isZero() {
        return this.getX() == 0 && this.getY() == 0 && this.getZ() == 0;
    }

    default boolean isEqual(IVec pos) {
        return this.getX() == pos.getX() && this.getY() == pos.getY() && this.getZ() == pos.getZ();
    }

    default boolean isNotEqual(IVec pos) {
        return !this.isEqual(pos);
    }

    default boolean isPositive() {
        return this.getX() > 0 && this.getY() > 0 && this.getZ() > 0;
    }

    default boolean isNegative() {
        return this.getX() < 0 && this.getY() < 0 && this.getZ() < 0;
    }

    default boolean isBlockVec() {
        return this instanceof BlockVec;
    }

    default boolean isChunkVec() {
        return this instanceof ChunkVec;
    }

    default boolean isVec() {
        return this instanceof Vec;
    }

    int getChunkX();
    int getChunkY();
    int getChunkZ();

    default IVec set(double x, double y, double z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
        return this;
    }

    default IVec set(IVec pos) {
        this.setX(pos.getX());
        this.setY(pos.getY());
        this.setZ(pos.getZ());
        return this;
    }
}
