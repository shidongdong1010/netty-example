package org.sdd.example1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Netty版的server
 *
 * @author 施冬冬
 * date: 2019/5/30 9:30
 */
public class NettyServer {

    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        // 用来接收进来的连接
        NioEventLoopGroup boos = new NioEventLoopGroup();
        // 用来处理已经被接收的连接
        NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap
                .group(boos, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {

                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                super.channelActive(ctx);
                                // 发送当前时间信息
                                System.out.println("连接加入: " + ctx.channel().remoteAddress());
                            }

                            @Override
                            protected void messageReceived(ChannelHandlerContext ctx, String msg) {
                                System.out.println(msg);
                                ctx.writeAndFlush("hello netty client");
                            }
                        });
                    }
                })
                .bind(8000);
    }

}
