package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;



public class TrainSensorTest {

    TrainController controller;
    TrainSensor sensor;
    TrainUser user;



    @Before
    public void before() {
        TrainSystem system = new TrainSystem();
        controller = system.getController();
        sensor = system.getSensor();
        user = system.getUser();
    }

    @Test
    public void ThisIsAnExampleTestStub() {

        Assert.assertEquals(10, controller.getReferenceSpeed());
        controller.followSpeed();
        Assert.assertEquals(10, controller.getReferenceSpeed());
    }


    }
