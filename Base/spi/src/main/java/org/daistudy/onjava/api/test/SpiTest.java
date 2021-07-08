package org.daistudy.onjava.api.test;

import org.daistudy.onjava.api.service.SayService;

import java.util.ServiceLoader;

public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<SayService> services = ServiceLoader.load(SayService.class);
        for (SayService sayService : services) {
            sayService.say("Hello");
        }
    }
}
