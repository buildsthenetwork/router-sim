package com.buildsthenetwork.Router.Hardware;

import java.util.UUID;

public class Link {
    private int bandwidth;
    private int delay;
    private RouterInterface r1;
    private RouterInterface r2;
    private UUID id;

    public Link(int bandwidth, int delay, RouterInterface r1, RouterInterface r2) {
        this.bandwidth = bandwidth;
        this.delay = delay;
        this.r1 = r1;
        this.r2 = r2;
        this.id = UUID.randomUUID();
    }

    public RouterInterface getRouterInterface1() {
        return r1;
    }

    public RouterInterface getRouterInterface2() {
        return r2;
    }
}
