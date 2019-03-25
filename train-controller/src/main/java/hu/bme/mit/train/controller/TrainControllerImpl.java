package hu.bme.mit.train.controller;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;

import java.util.Timer;
import java.util.TimerTask;


public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private Timer timer = new Timer();

	public Table<Integer, Integer, Integer> refspeed
			= HashBasedTable.create();

	public Table<String, String, Integer> time
			= HashBasedTable.create();


	public Table<String, String, Integer> joystikpos
			= HashBasedTable.create();


	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}

		refspeed.put(0,0,5);
		time.put("a","a",5);
		joystikpos.put("a","a",5);

		enforceSpeedLimit();



	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;

		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				enforceSpeedLimit();
			}
		}, 2*60*1000, 2*60*1000);

	}

}
