package org.sdd.example11;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;

import java.io.IOException;

/**
 * 整个代码文件描述
 *
 * @author 施冬冬
 * date: 2019/6/4 14:12
 */
public class ChannelBufferByteInput implements ByteInput {

    private final ByteBuf buffer;

    public ChannelBufferByteInput(ByteBuf buffer) {
        this.buffer = buffer;
    }

    @Override
    public void close() throws IOException {
        // nothing to do
    }

    @Override
    public int available() throws IOException {
        return buffer.readableBytes();
    }

    @Override
    public int read() throws IOException {
        if (buffer.isReadable()) {
            return buffer.readByte() & 0xff;
        }
        return -1;
    }

    @Override
    public int read(byte[] array) throws IOException {
        return read(array, 0, array.length);
    }

    @Override
    public int read(byte[] dst, int dstIndex, int length) throws IOException {
        int available = available();
        if (available == 0) {
            return -1;
        }

        length = Math.min(available, length);
        buffer.readBytes(dst, dstIndex, length);
        return length;
    }

    @Override
    public long skip(long bytes) throws IOException {
        int readable = buffer.readableBytes();
        if (readable < bytes) {
            bytes = readable;
        }
        buffer.readerIndex((int) (buffer.readerIndex() + bytes));
        return bytes;
    }

}