package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}


	/***
	 *
	 Absolute margin: If the new speed limit is under 0, or over 500.
	 Relative margin: If the new speed limit is more than 50% slower than the actual reference speed (e.g., 150 to 50 is an alarming situation, because 50 is more than 50% less than 150).

	 * @param speedLimit
	 */

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		//Absolute margin:
		if (speedLimit<0 || speedLimit>500)
			user.setAlarmState(true);
		else
			user.setAlarmState(false);

		//Relative margin:
		if (speedLimit<controller.getReferenceSpeed()*0.5)
			user.setAlarmState(true);
		else
			user.setAlarmState(false);


		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);


	}

}
