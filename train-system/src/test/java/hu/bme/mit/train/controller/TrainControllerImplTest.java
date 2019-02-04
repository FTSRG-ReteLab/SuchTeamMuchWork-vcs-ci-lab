package hu.bme.mit.train.controller;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrainControllerImplTest {

    TrainControllerImpl tc= new TrainControllerImpl();

    @Test
    public void followSpeed() {
        tc.followSpeed();

       assertNotNull(tc.refspeed);
    }
}