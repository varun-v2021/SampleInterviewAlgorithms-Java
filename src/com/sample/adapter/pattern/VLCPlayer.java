package com.sample.adapter.pattern;

public class VLCPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVLC(String fileName) {
		System.out.println("Playing VLC file...");
	}

	@Override
	public void playMP4(String fileName) {
		// TODO Auto-generated method stub
		//Do nothing
	}

}
