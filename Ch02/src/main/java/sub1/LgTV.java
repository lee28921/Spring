package sub1;

import org.springframework.beans.factory.annotation.Autowired;

public class LgTV {
	
	// Autowired 설정
	@Autowired
	private Speaker spk;
	
	public void powerOn() {
		System.out.println("LgTv powerOn...");
	}
	public void powerOff() {
		System.out.println("LgTv powerOff...");
	}
	public void soundUp() {
		spk.soundUp();
	}
	public void soundDown() {
		spk.soundDown();
	}
}
