package org.daistudy.onjava.api.service.impl;

import org.daistudy.onjava.api.service.SayService;

public class BSayServiceImpl implements SayService {
    @Override
    public void say(String word) {
        System.out.println(word + " B say: I am a boy");
    }
}
