/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mowbot.net;

import static org.jboss.netty.channel.Channels.*;

  import org.jboss.netty.channel.ChannelPipeline;
  import org.jboss.netty.channel.ChannelPipelineFactory;
  import org.jboss.netty.handler.codec.frame.DelimiterBasedFrameDecoder;
  import org.jboss.netty.handler.codec.frame.Delimiters;
  import org.jboss.netty.handler.codec.string.StringDecoder;
  import org.jboss.netty.handler.codec.string.StringEncoder;
/**
 *
 * @author justin.hawkins
 */
public class TcpClientPipelineFactory  implements  ChannelPipelineFactory {


      public ChannelPipeline getPipeline() throws Exception {
          // Create a default pipeline implementation.
          ChannelPipeline pipeline = pipeline();

          // Add the text line codec combination first,
          pipeline.addLast("framer", new DelimiterBasedFrameDecoder(
                  8192, Delimiters.lineDelimiter()));
          pipeline.addLast("decoder", new StringDecoder());
          pipeline.addLast("encoder", new StringEncoder());

          // and then business logic.
          pipeline.addLast("handler", new TcpClientHandler());

          return pipeline;
      }
  }
