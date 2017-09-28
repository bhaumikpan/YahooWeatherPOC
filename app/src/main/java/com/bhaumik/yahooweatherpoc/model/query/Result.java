package com.bhaumik.yahooweatherpoc.model.query;

import com.bhaumik.yahooweatherpoc.model.query.result.Channel;

/**
 * Created by bhaumik on 9/27/17.
 */

public class Result {

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "Result{" +
                "channel=" + channel +
                '}';
    }
}
