package dev.ultreon.quentangle.api.entity;

public interface IEntity {
    double quent$x();
    double quent$y();
    double quent$z();

    void quent$x(double x);
    void quent$y(double y);
    void quent$z(double z);

    void quent$pos(double x, double y, double z);
}
