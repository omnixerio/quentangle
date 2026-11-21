package dev.ultreon.quentangle.api.network.packet;

import java.util.UUID;

public interface IPacketIO {
    void quent$writeByte(byte value);

    void quent$writeShort(short value);

    void quent$writeInt(int value);

    void quent$writeLong(long value);

    void quent$writeFloat(float value);

    void quent$writeDouble(double value);

    void quent$writeString(String value);

    void quent$writeBoolean(boolean value);

    void quent$writeByteArray(byte[] value);

    byte quent$readByte();

    short quent$readShort();

    int quent$readInt();

    long quent$readLong();

    float quent$readFloat();

    double quent$readDouble();

    String quent$readString();

    boolean quent$readBoolean();

    byte[] quent$readByteArray();

    void quent$writeVarInt(int value);

    int quent$readVarInt();

    void quent$writeUUID(UUID value);

    UUID quent$readUUID();
}
