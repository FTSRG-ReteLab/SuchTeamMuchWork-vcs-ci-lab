package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Before
    public void before() {
        // TODO Add initializations
    }

    @Test
    public void ThisIsAnExampleTestStub() {

	private TrainController controller;
	private TrainUser user;

    TrainSensorImpl tsi=new TrainSensorImpl(controller, user);

	assertEquals(5,tsi.getSpeedLimit(), "default value must be 5");    


    }
}
