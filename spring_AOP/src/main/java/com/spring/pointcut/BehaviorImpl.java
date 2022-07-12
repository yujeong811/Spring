package com.spring.pointcut;

public class BehaviorImpl implements Behavior {

	@Override
	public void 잠자기() {
		System.out.println("쿨쿨~잠을 잡니다.");

	}

	@Override
	public void 공부하기() {
		System.out.println("열심히 공부를 합니다.");

	}

	@Override
	public void 밥먹기() {
		System.out.println("냠냠..쩝쩝..다 흘리고 먹어요....");

	}

	@Override
	public void 데이트() {
		System.out.println("귀찮아...데이트....");

	}

	@Override
	public void 운동() {
		System.out.println("열심히 운동을 합니다.");

	}

	@Override
	public void 놀기() {
		System.out.println("신나게 놀아보쟈~~");

	}

	@Override
	public void 정신수양() {
		System.out.println("정신집중...");

	}

}
