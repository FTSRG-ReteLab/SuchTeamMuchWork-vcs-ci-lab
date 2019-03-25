package hu.bme.mit.train.sensor;


import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController controller;
    TrainSensor sensor;
    TrainUser user;


    @Before
    public void before() {
        user = mock(TrainUserImpl.class);
        controller = mock(TrainControllerImpl.class);
        sensor = new TrainSensorImpl(controller,user );

    }

    @Test
    public void TestSpeedNegative() {
        sensor.overrideSpeedLimit(-5);
        Assert.assertTrue(user.getAlarmState());
    }


    @Test
    public void TestSpeedOver500() {
        sensor.overrideSpeedLimit(501);
        Assert.assertTrue(user.getAlarmState());
    }



    @Test
    public void mockit(){



    }

}