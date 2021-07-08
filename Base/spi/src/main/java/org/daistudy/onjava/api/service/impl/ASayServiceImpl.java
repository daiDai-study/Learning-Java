package org.daistudy.onjava.api.service.impl;

import org.daistudy.onjava.api.service.SayService;

public class ASayServiceImpl implements SayService {
    @Override
    public void say(String word) {
        System.out.println(word + " A say: I am a boy");
    }
}
